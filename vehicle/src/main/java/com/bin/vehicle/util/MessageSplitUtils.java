package com.bin.vehicle.util;

import com.bin.common.constant.VehicleConstant;
import com.bin.vehicle.entity.*;

import java.util.*;

public class MessageSplitUtils {
    private MessageSplitUtils() {}
    /**
     * 分割协议的报文, 返回一个map
     * @param infoStr
     * @param beginStr
     * @param endStr
     * @return
     */

    private static Map<String, String> getSplitMessage(String infoStr, String beginStr, String endStr) {
        Map<String, String> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        int lastIndexOfEnd = infoStr.lastIndexOf(endStr);
        int beginIndex = 0;
        while (beginIndex < lastIndexOfEnd) {
            int begin = infoStr.indexOf(beginStr, beginIndex);
            int end = infoStr.indexOf(endStr, beginIndex);
            String singleInfo = infoStr.substring(begin + 2, end);
            String[] splitInfo = singleInfo.split("=");
            map.put(splitInfo[0], splitInfo[1]);
            beginIndex = end + 1;
        }
        return map;
    }

    /**
     * 封装每个实体类的构造器参数
     * @param map
     */
    private static Map<String, List<String>> initMessage(Map<String, String> map) {
        List<String> GpsInfo = Arrays.asList(map.get(VehicleConstant.GpsInfo).split(","));
        List<String> BatterySys_1 = Arrays.asList(map.get(VehicleConstant.BatterySys_1).split(","));
        List<String> BatterySys_2 = Arrays.asList(map.get(VehicleConstant.BatterySys_2).split(","));
        List<String> VnumAndSoftVersin = Arrays.asList(map.get(VehicleConstant.VnumAndSoftVersin).split(","));
        List<String> DashboardRequire_1 = Arrays.asList(map.get(VehicleConstant.DashboardRequire_1).split(","));
        List<String> DashboardRequire_2 = Arrays.asList(map.get(VehicleConstant.DashboardRequire_2).split(","));
        List<String> SingleVoltage = Arrays.asList(map.get(VehicleConstant.SingleVoltage).split(","));
        List<String> TempInfo = Arrays.asList(map.get(VehicleConstant.TempInfo).split(","));
        List<String> BatteryStateOne = Arrays.asList(map.get(VehicleConstant.BatteryStateOne).split(","));
        List<String> BatteryStateTwo = Arrays.asList(map.get(VehicleConstant.BatteryStateTwo).split(","));
        List<String> BatteryStateFour = Arrays.asList(map.get(VehicleConstant.BatteryStateFour).split(","));
        List<String> BatteryStateFive = Arrays.asList(map.get(VehicleConstant.BatteryStateFive).split(","));
        List<String> BatteryStateSix = Arrays.asList(map.get(VehicleConstant.BatteryStateSix).split(","));
        List<String> BatteryStateSeven = Arrays.asList(map.get(VehicleConstant.BatteryStateSeven).split(","));
        List<String> PowerCountInfo = Arrays.asList(map.get(VehicleConstant.PowerCountInfo).split(","));

        Map<String, List<String>> argListMap = new HashMap<>();
        argListMap.put("GpsInfo", GpsInfo);
        argListMap.put("BatterySys_1", BatterySys_1);
        argListMap.put("BatterySys_2", BatterySys_2);
        argListMap.put("VnumAndSoftVersin", VnumAndSoftVersin);
        argListMap.put("DashboardRequire_1", DashboardRequire_1);
        argListMap.put("DashboardRequire_2", DashboardRequire_2);
        argListMap.put("SingleVoltage", SingleVoltage);
        argListMap.put("TempInfo", TempInfo);
        argListMap.put("BatteryStateOne", BatteryStateOne);
        argListMap.put("BatteryStateTwo", BatteryStateTwo);
        argListMap.put("BatteryStateFour", BatteryStateFour);
        argListMap.put("BatteryStateFive", BatteryStateFive);
        argListMap.put("BatteryStateSix", BatteryStateSix);
        argListMap.put("BatteryStateSeven", BatteryStateSeven);
        argListMap.put("PowerCountInfo", PowerCountInfo);

        return argListMap;
    }

    private static Map<String, Object> getEntities(Map<String, List<String>> argListMap) {
        Map<String, Object> resultMap = new HashMap<>();
        GpsInfo gpsInfo = new GpsInfo(argListMap.get("GpsInfo"));
        BatterySys batterySys = new BatterySys(argListMap.get("BatterySys_1"), argListMap.get("BatterySys_2"));
        VnumAndSoftVersin vnumAndSoftVersin = new VnumAndSoftVersin(argListMap.get("VnumAndSoftVersin"));
        DashboardRequire dashboardRequire = new DashboardRequire(argListMap.get("DashboardRequire_1"), argListMap.get("DashboardRequire_2"));
        SingleVoltage singleVoltage = new SingleVoltage(argListMap.get("SingleVoltage"));
        TempInfo tempInfo = new TempInfo(argListMap.get("TempInfo"));
        BatteryStateOne batteryStateOne = new BatteryStateOne(argListMap.get("BatteryStateOne"));
        BatteryStateTwo batteryStateTwo = new BatteryStateTwo(argListMap.get("BatteryStateTwo"));
        BatteryStateFour batteryStateFour = new BatteryStateFour(argListMap.get("BatteryStateFour"));
        BatteryStateFive batteryStateFive = new BatteryStateFive(argListMap.get("BatteryStateFive"));
        BatteryStateSix batteryStateSix = new BatteryStateSix(argListMap.get("BatteryStateSix"));
        BatteryStateSeven batteryStateSeven = new BatteryStateSeven(argListMap.get("BatteryStateSeven"));
        PowerCountInfo powerCountInfo = new PowerCountInfo(argListMap.get("PowerCountInfo"));

        resultMap.put("gpsInfo", gpsInfo);
        resultMap.put("batterySys", batterySys);
        resultMap.put("vnumAndSoftVersin", vnumAndSoftVersin);
        resultMap.put("dashboardRequire", dashboardRequire);
        resultMap.put("singleVoltage", singleVoltage);
        resultMap.put("tempInfo", tempInfo);
        resultMap.put("batteryStateOne", batteryStateOne);
        resultMap.put("batteryStateTwo", batteryStateTwo);
        resultMap.put("batteryStateFour", batteryStateFour);
        resultMap.put("batteryStateFive", batteryStateFive);
        resultMap.put("batteryStateSix", batteryStateSix);
        resultMap.put("batteryStateSeven", batteryStateSeven);
        resultMap.put("powerCountInfo", powerCountInfo);

        return resultMap;
    }

    public static Map<String, Object> getResultEntitesMap(String infoStr, String beginStr, String endStr) {
        Map<String, String> splitMessage = getSplitMessage(infoStr, beginStr, endStr);
        Map<String, List<String>> stringListMap = initMessage(splitMessage);
        Map<String, Object> entities = getEntities(stringListMap);
        return entities;
    }

}
