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
@ApiModel(value="BatteryStateOne对象", description="")
public class BatteryStateOne implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "Bit0~1：主正继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer mainPositiveState;

    @ApiModelProperty(value = "Bit2~3：主负继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer mainNegativeState;

    @ApiModelProperty(value = "Bit4~5： 主回路预充或预检继电器	状态（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer mainCircleState;

    @ApiModelProperty(value = "Bit6~7： 直流充电正继电器 1 状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    @TableField("DC_charge_positive1_state")
    private Integer dcChargePositive1State;

    @ApiModelProperty(value = "Bit0~1：直流充电负继电器 1 状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    @TableField("DC_charge_negative1_state")
    private Integer dcChargeNegative1State;

    @ApiModelProperty(value = "Bit2~3： 直流充电正继电器 2 状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    @TableField("DC_charge_positive2_state")
    private Integer dcChargePositive2State;

    @ApiModelProperty(value = "Bit4~5： 直流充电负继电器 2 状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    @TableField("DC_charge_negative2_state")
    private Integer dcChargeNegative2State;

    @ApiModelProperty(value = "Bit6~7： 加热正继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer heatPositiveState;

    @ApiModelProperty(value = "Bit0~1：加热负继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer heatNegativeState;

    @ApiModelProperty(value = "Bit2~3：集电弓正继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer pantographPositiveState;

    @ApiModelProperty(value = "Bit4~5：集电弓负继电器状态 	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer pantographNegativeState;

    @ApiModelProperty(value = "Bit6~7： 交流充电正继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    @TableField("AC_charge_positive_state")
    private Integer acChargePositiveState;

    @ApiModelProperty(value = "Bit0~1：交流充电负继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    @TableField("AC_charge_negative_state")
    private Integer acChargeNegativeState;

    @ApiModelProperty(value = "Bit2~3：附件 1 继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer attach1State;

    @ApiModelProperty(value = "Bit4~5：附件 2 继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer attach2State;

    @ApiModelProperty(value = "Bit6~7：附件 3 继电器状态	（如状态由 BMS 检测）	0： Reserved 1： Opend	2： Closed 3： Invalid")
    private Integer attach3State;

    @ApiModelProperty(value = "Bit0~1： BMS 当前高压状态	0： HV open 	1： Precharge	2： HV closed 	3： Fail to HV on")
    @TableField("BMS_high_state")
    private Integer bmsHighState;

    @ApiModelProperty(value = "Bit2： BMS 当前均衡状态 	0：无均衡 1：均衡")
    private Integer balanceState;

    @ApiModelProperty(value = "Bit3~4： 直流充电枪连接状态	0：无连接 1：单枪连接	2：双枪连接 3：无效")
    @TableField("DC_charge_gun_state")
    private Integer dcChargeGunState;

    @ApiModelProperty(value = "Bit5： 集电弓充电枪连接状态 	0：未连接 1：连接")
    private Integer pantographChargeGunState;

    @ApiModelProperty(value = "Bit6： 交流充电枪连接状态 	0：未连接 1：连接")
    @TableField("AC_charge_gun_state")
    private Integer acChargeGunState;

    @ApiModelProperty(value = "Bit7~8： BMS 当前充电模式	0：未充电 1：直流充电	2：交流充电 3：其他")
    @TableField("BMS_charge_mode")
    private Integer bmsChargeMode;

    @ApiModelProperty(value = "Bit9~10：充电状态	0：未充电 1： 充电	2： 充电完成 3：充电故障")
    private Integer chargeState;

    @ApiModelProperty(value = "Bit11：当前加热状态 	0：无加热 1：加热")
    private Integer heatState;

    @ApiModelProperty(value = "Bit12~13：当前冷却状态 	0：无冷却 1：冷却")
    private Integer coolState;

    @ApiModelProperty(value = "充电次数")
    private Integer chargeCount;

    public BatteryStateOne(List<String> args) {
        this.mainPositiveState = Integer.parseInt(args.get(0));
        this.mainNegativeState = Integer.parseInt(args.get(1));
        this.mainCircleState = Integer.parseInt(args.get(2));
        this.dcChargePositive1State = Integer.parseInt(args.get(3));
        this.dcChargeNegative1State = Integer.parseInt(args.get(4));
        this.dcChargePositive2State = Integer.parseInt(args.get(5));
        this.dcChargeNegative2State = Integer.parseInt(args.get(6));
        this.heatPositiveState = Integer.parseInt(args.get(7));
        this.heatNegativeState = Integer.parseInt(args.get(8));
        this.pantographPositiveState = Integer.parseInt(args.get(9));
        this.pantographNegativeState = Integer.parseInt(args.get(10));
        this.acChargePositiveState = Integer.parseInt(args.get(11));
        this.acChargeNegativeState = Integer.parseInt(args.get(12));
        this.attach1State = Integer.parseInt(args.get(13));
        this.attach2State = Integer.parseInt(args.get(14));
        this.attach3State = Integer.parseInt(args.get(15));
        this.bmsHighState = Integer.parseInt(args.get(16));
        this.balanceState = Integer.parseInt(args.get(17));
        this.dcChargeGunState = Integer.parseInt(args.get(18));
        this.pantographChargeGunState = Integer.parseInt(args.get(19));
        this.acChargeGunState = Integer.parseInt(args.get(20));
        this.bmsChargeMode = Integer.parseInt(args.get(21));
        this.chargeState = Integer.parseInt(args.get(22));
        this.heatState = Integer.parseInt(args.get(23));
        this.coolState = Integer.parseInt(args.get(24));
        this.chargeCount = Integer.parseInt(args.get(25));
    }
}
