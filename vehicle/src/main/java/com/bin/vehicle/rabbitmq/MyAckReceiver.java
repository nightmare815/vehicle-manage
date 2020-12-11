//package com.bin.vehicle.rabbitmq;
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.bin.vehicle_manage.entity.*;
//import com.bin.vehicle_manage.service.*;
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.text.ParseException;
//import java.util.*;
//
///**
// * 手动确认消息监听类
// */
//@Component
//public class MyAckReceiver implements ChannelAwareMessageListener {
//
//
//    @Value("${myrabbitmq.queue.receiver}")
//    private String receiveQueue;
//
//    @Value("${myrabbitmq.queue.errorlog}")
//    private String errorQueue;
//
//    @Value("${myrabbitmq.queue.message.prefix}")
//    private String msgPrefix;
//
//    @Value("${myrabbitmq.queue.message.suffix}")
//    private String msgSuffix;
//
//    //重发最大次数
//    @Value("${myrabbitmq.queue.redeliver-count}")
//    private int maxCount;
//
//    private int count = 0;
//
//    @Autowired
//    private GpsInfoService gpsInfoService;
//
//    @Autowired
//    private ChargeStateService chargeStateService;
//
//    @Autowired
//    private FaultLevelService faultLevelService;
//
//    @Autowired
//    private FlagService flagService;
//
//    @Autowired
//    private MaxAndMinTempService maxAndMinTempService;
//
//    @Autowired
//    private MaxAndMinVoltageService maxAndMinVoltageService;
//
//    @Autowired
//    private SingleTempService singleTempService;
//
//    @Autowired
//    private SingleVoltageService singleVoltageService;
//
//    @Autowired
//    private VehicleInfoService vehicleInfoService;
//
//    @Autowired
//    private VehicleStateService vehicleStateService;
//
//    @Autowired
//    private ErrorLogService errorLogService;
//
//
//    @Override
//    public void onMessage(Message message, Channel channel) throws Exception {
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        try {
//            String queue = message.getMessageProperties().getConsumerQueue();
//            if (errorQueue.equals(queue)) {
//                //如果是来自错误日志队列里面的消息,就放入数据库中错误日志表
////                String errorMessage = new String(message.getBody());
////                ErrorLog errorLog = new ErrorLog();
////                errorLog.setErrInfo(errorMessage);
////                errorLogService.save(errorLog);
//                channel.basicAck(deliveryTag, true); //第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
//            } else {
////                Map<String, Object> map = formatInfo(message);
////            System.out.println(map);
//
////            System.out.println("消息体: " + new String(message.getBody()));
////            System.out.println("分割的消息体: " + message.toString().split("'")[1]);
////            System.out.println("消费的消息来自队列的名字："+message.getMessageProperties().getConsumerQueue());
////            System.out.println("消费的消息来自路由键："+message.getMessageProperties().getReceivedRoutingKey());
//                channel.basicAck(deliveryTag, true); //第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
//            }
//        } catch (Exception e) {
////            System.out.println("消息未确认~!");
//            //如果重发次数大于5次, 丢弃此条消息
//            if (count > maxCount) {
//                channel.basicNack(deliveryTag, false, false);
//                System.out.println("重发次数大于" + maxCount + "次, 消息被丢弃!");
//                count = 0;
//            } else {
//                channel.basicReject(deliveryTag, true);//第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
//                count++;
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public Map<String, Object> formatInfo(Message message) throws ParseException, InterruptedException {
//        //得到消息体
//        String content = new String(message.getBody());
//        Map<String, String> info = getInfo(content, msgPrefix, msgSuffix);
//        GpsInfo gpsInfo = new GpsInfo(Arrays.asList(msgList.get(0).split(",")));
//        VehicleInfo vehicleInfo = new VehicleInfo(Arrays.asList(msgList.get(1).split(",")));
//        VehicleState vehicleState = new VehicleState(Arrays.asList(msgList.get(2).split(",")));
//        Flag flag = new Flag(Arrays.asList(msgList.get(3).split(",")));
//        FaultLevel faultLevel = new FaultLevel(Arrays.asList(msgList.get(4).split(",")));
//        MaxAndMinVoltage maxAndMinVoltage = new MaxAndMinVoltage(Arrays.asList(msgList.get(5).split(",")));
//        MaxAndMinTemp maxAndMinTemp = new MaxAndMinTemp(Arrays.asList(msgList.get(6).split(",")));
//        ChargeState chargeState = new ChargeState(Arrays.asList(msgList.get(7).split(",")));
//
//        gpsInfoService.save(gpsInfo);
//        vehicleInfoService.save(vehicleInfo);
//        vehicleStateService.save(vehicleState);
//        flagService.save(flag);
//        faultLevelService.save(faultLevel);
//        maxAndMinVoltageService.save(maxAndMinVoltage);
//        maxAndMinTempService.save(maxAndMinTemp);
//        chargeStateService.save(chargeState);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("gpsInfo", gpsInfo);
//        map.put("vehicleInfo", vehicleInfo);
//        map.put("vehicleState", vehicleState);
//        map.put("flag", flag);
//        map.put("faultLevel", faultLevel);
//        map.put("maxAndMinVoltage", maxAndMinVoltage);
//        map.put("maxAndMinTemp", maxAndMinTemp);
//        map.put("chargeState", chargeState);
//
//        List<SingleTemp> singleTempList = new ArrayList<>();
//        for (int i = 8; i < 14; i++) {
//            SingleTemp singleTemp = new SingleTemp(Arrays.asList(msgList.get(i).split(",")));
//            Thread.sleep(20);
//            singleTempService.save(singleTemp);
//            singleTempList.add(singleTemp);
//        }
//        map.put("SingleTemp", singleTempList);
//
//        List<SingleVoltage> singleVoltageList = new ArrayList<>();
//        for (int i = 14; i < 68; i++) {
//            SingleVoltage singleVoltage = new SingleVoltage(Arrays.asList(msgList.get(i).split(",")));
//            Thread.sleep(20);
//            singleVoltageService.save(singleVoltage);
//            singleVoltageList.add(singleVoltage);
//        }
//        map.put("SingleVoltage", singleTempList);
//        return map;
//    }
//
//    public Map<String, String> getInfo(String infoStr, String beginStr, String endStr) {
//        Map<String, String> map = new HashMap<>();
//
//        List<String> list = new ArrayList<>();
//        int lastIndexOfEnd = infoStr.lastIndexOf(endStr);
//        int beginIndex = 0;
//        while (beginIndex < lastIndexOfEnd) {
//            int begin = infoStr.indexOf(beginStr, beginIndex);
//            int end = infoStr.indexOf(endStr, beginIndex);
//            String singleInfo = infoStr.substring(begin + 2, end);
//            String[] splitInfo = singleInfo.split("=");
//            map.put(splitInfo[0], splitInfo[1]);
//            beginIndex = end + 1;
//        }
//        return map;
//    }
//}