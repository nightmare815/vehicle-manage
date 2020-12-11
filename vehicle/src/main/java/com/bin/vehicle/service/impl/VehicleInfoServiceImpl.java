package com.bin.vehicle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bin.vehicle.entity.VehicleInfo;
import com.bin.vehicle.mapper.VehicleInfoMapper;
import com.bin.vehicle.service.VehicleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bin.vehicle.vo.SingleMonitorVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bintian
 * @since 2020-12-09
 */
@Service
public class VehicleInfoServiceImpl extends ServiceImpl<VehicleInfoMapper, VehicleInfo> implements VehicleInfoService {

    @Override
    public Map<String, Object> singleMonitorByCondition(SingleMonitorVo singleMonitorVo, Long current, Long limit) {
        QueryWrapper<VehicleInfo> wrapper = new QueryWrapper<>();
        Page<VehicleInfo> page = new Page<>(current, limit);
        String factory = singleMonitorVo.getFactory();
        String type = singleMonitorVo.getType();
        String vin = singleMonitorVo.getVin();
        if (!StringUtils.isEmpty(factory)) {
            wrapper.eq("factory", factory);
        }
        if (!StringUtils.isEmpty(type)) {
            wrapper.eq("vehicle_type", type);
        }
        if (!StringUtils.isEmpty(vin)) {
            wrapper.eq("vin", vin);
        }
        this.page(page);
        Map<String, Object> map = new HashMap<>();
        List<VehicleInfo> records = page.getRecords();
        long total = page.getTotal();
        map.put("records", records);
        map.put("total", total);
        return map;
    }
}
