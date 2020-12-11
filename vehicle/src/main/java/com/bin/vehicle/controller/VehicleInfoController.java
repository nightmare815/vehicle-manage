package com.bin.vehicle.controller;


import com.bin.common.utils.Result;
import com.bin.vehicle.entity.GpsInfo;
import com.bin.vehicle.entity.VehicleInfo;
import com.bin.vehicle.service.VehicleInfoService;
import com.bin.vehicle.vo.SingleMonitorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bintian
 * @since 2020-12-09
 */
@RestController
@CrossOrigin
@RequestMapping("/vehicle/vehicleinfo")
public class VehicleInfoController {
    @Autowired
    VehicleInfoService vehicleInfoService;

    //获得所有车辆信息
    @GetMapping("info")
    public Result getAllVehicleInfo() {
        List<VehicleInfo> list = vehicleInfoService.list();
        return Result.ok().data("vehicleInfoList", list);
    }

    //根据id获得所有车辆信息
    @GetMapping("info/{vin}")
    public Result getAllVehicleInfo(@PathVariable String vin) {
        VehicleInfo info = vehicleInfoService.getById(vin);
        return Result.ok().data("info", info);
    }

    //单车监控带条件分页
    @PostMapping("singleMonitorByCondition/{current}/{limit}")
    public Result singleMonitorByCondition(@RequestBody SingleMonitorVo singleMonitorVo, @PathVariable Long current, @PathVariable Long limit) {
        Map<String, Object> singleList = vehicleInfoService.singleMonitorByCondition(singleMonitorVo,current,limit);
        return Result.ok().data(singleList);
    }
}

