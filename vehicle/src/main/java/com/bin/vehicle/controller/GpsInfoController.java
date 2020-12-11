package com.bin.vehicle.controller;


import com.bin.common.utils.Result;
import com.bin.vehicle.entity.GpsInfo;
import com.bin.vehicle.service.GpsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bintian
 * @since 2020-12-08
 */
@RestController
@CrossOrigin
@RequestMapping("/vehicle/gpsinfo")
public class GpsInfoController {

    @Autowired
    GpsInfoService gpsInfoService;

    //获得所有车辆GPS信息
    @GetMapping("gpsinfo")
    public Result getAllGpsInfo() {
        List<GpsInfo> list = gpsInfoService.list();
        return Result.ok().data("gpsInfoList", list);
    }
}

