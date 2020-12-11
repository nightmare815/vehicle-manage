package com.bin.vehicle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author bintian
 * @since 2020-12-08
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BatteryStateFive对象", description="")
public class BatteryStateFive implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "电芯电压最大值")
    private Double cellMaxVoltage;

    @ApiModelProperty(value = "电芯电压最小值")
    private Double cellMinVoltage;

    @ApiModelProperty(value = "电芯电压平均值")
    private Double cellAvgVoltage;

    public BatteryStateFive(List<String> args) {
        this.cellMaxVoltage = Double.parseDouble(args.get(0));
        this.cellMinVoltage = Double.parseDouble(args.get(1));
        this.cellAvgVoltage = Double.parseDouble(args.get(2));
    }


}
