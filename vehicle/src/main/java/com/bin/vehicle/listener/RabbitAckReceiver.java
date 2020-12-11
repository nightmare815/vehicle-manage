package com.bin.vehicle.listener;

import com.bin.vehicle.entity.*;
import com.bin.vehicle.service.*;
import com.bin.vehicle.util.MessageSplitUtils;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class RabbitAckReceiver implements ChannelAwareMessageListener {

    @Value("${myrabbitmq.queue.receiver}")
    private String receiveQueue;
    @Value("${myrabbitmq.queue.errorlog}")
    private String errlogQueue;
    @Value("${myrabbitmq.queue.message.prefix}")
    private String messagePrefix;
    @Value("${myrabbitmq.queue.message.suffix}")
    private String messageSuffix;
    //重发最大次数
    @Value("${myrabbitmq.queue.redeliver-count}")
    private int maxCount;

    private int count = 0;

    @Autowired
    BatteryStateFiveService batteryStateFiveService;
    @Autowired
    BatteryStateFourService batteryStateFourService;
    @Autowired
    BatteryStateOneService batteryStateOneService;
    @Autowired
    BatteryStateSevenService batteryStateSevenService;
    @Autowired
    BatteryStateSixService batteryStateSixService;
    @Autowired
    BatteryStateTwoService batteryStateTwoService;
    @Autowired
    BatterySysService batterySysService;
    @Autowired
    DashboardRequireService dashboardRequireService;
    @Autowired
    GpsInfoService gpsInfoService;
    @Autowired
    PowerCountInfoService powerCountInfoService;
    @Autowired
    SingleVoltageService singleVoltageService;
    @Autowired
    TempInfoService tempInfoService;
    @Autowired
    VnumAndSoftVersinService vnumAndSoftVersinService;
    @Autowired
    VehicleInfoService vehicleInfoService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        String consumerQueue = message.getMessageProperties().getConsumerQueue();

        try {
            if (receiveQueue.equals(consumerQueue)) {
                //如果是来自正常消息队列
                String content = new String(message.getBody());
                System.out.println(content);
                //分割报文, 并拿到各个实体类的map
                Map<String, Object> resultEntitesMap = MessageSplitUtils.getResultEntitesMap(content, messagePrefix, messageSuffix);
                //存入数据库
                saveInfo(resultEntitesMap);


                channel.basicAck(deliveryTag, false);   //第二个参数为true时,可一次性确认deliveryTag小于传入值的所有消息
            }

            if (errlogQueue.equals(consumerQueue)) {
                //如果是来自故障日志消息队列

                channel.basicAck(deliveryTag, false);   //第二个参数为true时,可一次性确认deliveryTag小于传入值的所有消息
            }
        } catch (Exception e) {
            //如果重发次数大于最大次, 丢弃此条消息
            if (count > maxCount) {
                channel.basicNack(deliveryTag, false, false);
                System.out.println("重发次数大于" + maxCount + "次, 消息被丢弃!");
                log.error("发送失败, 消息被丢弃, 消息内容[{}]", new String(message.getBody()));
                count = 0;
            } else {
                channel.basicReject(deliveryTag, true);//第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
                count++;
            }
            e.printStackTrace();
        }
    }

    public void saveInfo(Map<String, Object> resultEntitesMap) {
        GpsInfo gpsInfo = (GpsInfo) resultEntitesMap.get("gpsInfo");
        BatterySys batterySys = (BatterySys) resultEntitesMap.get("batterySys");
        VnumAndSoftVersin vnumAndSoftVersin = (VnumAndSoftVersin) resultEntitesMap.get("vnumAndSoftVersin");
        DashboardRequire dashboardRequire = (DashboardRequire) resultEntitesMap.get("dashboardRequire");
        SingleVoltage singleVoltage = (SingleVoltage) resultEntitesMap.get("singleVoltage");
        TempInfo tempInfo = (TempInfo) resultEntitesMap.get("tempInfo");
        BatteryStateOne batteryStateOne = (BatteryStateOne) resultEntitesMap.get("batteryStateOne");
        BatteryStateTwo batteryStateTwo = (BatteryStateTwo) resultEntitesMap.get("batteryStateTwo");
        BatteryStateFour batteryStateFour = (BatteryStateFour) resultEntitesMap.get("batteryStateFour");
        BatteryStateFive batteryStateFive = (BatteryStateFive) resultEntitesMap.get("batteryStateFive");
        BatteryStateSix batteryStateSix = (BatteryStateSix) resultEntitesMap.get("batteryStateSix");
        BatteryStateSeven batteryStateSeven = (BatteryStateSeven) resultEntitesMap.get("batteryStateSeven");
        PowerCountInfo powerCountInfo = (PowerCountInfo) resultEntitesMap.get("powerCountInfo");

        //拿到vin码
        String vin = batterySys.getVin();
        gpsInfo.setVin(vin);

        //更新经纬度信息
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVin(vin);
        vehicleInfo.setLat(gpsInfo.getLat());
        vehicleInfo.setLng(gpsInfo.getLng());
        vehicleInfoService.updateById(vehicleInfo);


        gpsInfoService.save(gpsInfo);
        String id = gpsInfo.getId();

        batterySys.setId(id);
        vnumAndSoftVersin.setId(id);
        dashboardRequire.setId(id);
        singleVoltage.setId(id);
        tempInfo.setId(id);
        batteryStateOne.setId(id);
        batteryStateTwo.setId(id);
        batteryStateFour.setId(id);
        batteryStateFive.setId(id);
        batteryStateSix.setId(id);
        batteryStateSeven.setId(id);
        powerCountInfo.setId(id);

        batterySysService.save(batterySys);
        vnumAndSoftVersinService.save(vnumAndSoftVersin);
        dashboardRequireService.save(dashboardRequire);
        singleVoltageService.save(singleVoltage);
        tempInfoService.save(tempInfo);
        batteryStateOneService.save(batteryStateOne);
        batteryStateTwoService.save(batteryStateTwo);
        batteryStateFourService.save(batteryStateFour);
        batteryStateFiveService.save(batteryStateFive);
        batteryStateSixService.save(batteryStateSix);
        batteryStateSevenService.save(batteryStateSeven);
        powerCountInfoService.save(powerCountInfo);
    }
}
