package com.bin.vehicle.service;

import com.bin.vehicle.entity.VehicleInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bin.vehicle.vo.SingleMonitorVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bintian
 * @since 2020-12-09
 */
public interface VehicleInfoService extends IService<VehicleInfo> {

    Map<String, Object> singleMonitorByCondition(SingleMonitorVo singleMonitorVo, Long current, Long limit);
}
