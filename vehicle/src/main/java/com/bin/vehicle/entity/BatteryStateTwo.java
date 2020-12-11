package com.bin.vehicle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="BatteryStateTwo对象", description="")
public class BatteryStateTwo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "电池包 SOC	分辨率0.4%/bit	数据范围0~100%")
    private Double batterySoc;

    @ApiModelProperty(value = "电池包 SOH	分辨率0.4%/bit	数据范围0~100%")
    private Double batterySoh;

    @ApiModelProperty(value = "电池包总电流低字节	分辨率0.1A/bit	数据范围-1000~1000	充电为负，放电为正")
    private Double batterySumCurrent;

    @ApiModelProperty(value = "电池包总电压低字节	分辨率0.1V/bit	数据范围0~1000")
    private Double batterySumVoltage;

    @ApiModelProperty(value = "故障码")
    private String faultCode;

    @ApiModelProperty(value = "Bit0~1：当前最高故障等级	0：正常； 1~3 对应故障等级")
    private Integer faultMaxLevel;

    @ApiModelProperty(value = "Bit2~3： BMS 下高压请求	1：请求下电 2：无请求")
    @TableField("BMS_low_high_request")
    private Integer bmsLowHighRequest;

    @ApiModelProperty(value = "BMS 生命信号")
    @TableField("BMS_life_signal")
    private String bmsLifeSignal;

    public BatteryStateTwo(List<String> args) {
        this.batterySoc = Double.parseDouble(args.get(0));
        this.batterySoh = Double.parseDouble(args.get(1));
        this.batterySumCurrent = Double.parseDouble(args.get(2));
        this.batterySumVoltage = Double.parseDouble(args.get(3));
        this.faultCode = args.get(4);
        this.faultMaxLevel = Integer.parseInt(args.get(5));
        this.bmsLowHighRequest = Integer.parseInt(args.get(6));
        this.bmsLifeSignal = args.get(7);
    }

}
