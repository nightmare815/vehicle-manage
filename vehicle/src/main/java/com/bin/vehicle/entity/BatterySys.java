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
@ApiModel(value="BatterySys对象", description="")
public class BatterySys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    private Integer life;

    @ApiModelProperty(value = "主回路上下高压指令,0:Reserved 1:PowOn")
    private Integer mainCircleHighVoltage;

    @ApiModelProperty(value = "附件1回路上下高压指令 0:Reserved 1:PowOn")
    private Integer attach1CircleHighVoltage;

    @ApiModelProperty(value = "附件2回路上下高压指令 0:Reserved 1:PowOn")
    private Integer attach2CircleHighVoltage;

    @ApiModelProperty(value = "附件3回路上下高压指令 0:Reserved 1:PowOn")
    private Integer attach3CircleHighVoltage;

    @ApiModelProperty(value = "车速 分辨率1km/h/bit")
    private Integer vehicleSpeed;

    @ApiModelProperty(value = "整车端主正继电器触点状态 0： Reserved 1： Opend")
    private Integer mainPositiveTouchState;

    @ApiModelProperty(value = "整车端主正继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer mainPositiveFaultState;

    @ApiModelProperty(value = "整车端主负继电器触点状态 0： Reserved 1： Opend")
    private Integer mainNagetiveTouchState;

    @ApiModelProperty(value = "整车端主负继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer mainNagetiveFaultState;

    @ApiModelProperty(value = "整车端充电正继电器触点状态 0： Reserved 1： Opend")
    private Integer chargePositiveTouchState;

    @ApiModelProperty(value = "整车端充电正继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer chargePositiveFaultState;

    @ApiModelProperty(value = "整车端加热正继电器触点状态0： Reserved 1： Opend")
    private Integer heatPositiveTouchState;

    @ApiModelProperty(value = "整车端加热正继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer heatPositiveFaultState;

    @ApiModelProperty(value = "整车端加热负继电器触点状态 0： Reserved 1： Opend")
    private Integer heatNagetiveTouchState;

    @ApiModelProperty(value = "整车端加热负继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer heatNagetiveFaultState;

    @ApiModelProperty(value = "整车端辅件 1 继电器触点状态 0： Reserved 1： Opend")
    private Integer accessoryOneTouchState;

    @ApiModelProperty(value = "整车端辅件 1 继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer accessoryOneFaultState;

    @ApiModelProperty(value = "整车端辅件 2 继电器触点状态 0： Reserved 1： Opend")
    private Integer accessoryTwoTouchState;

    @ApiModelProperty(value = "整车端辅件 2 继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer accessoryTwoFaultState;

    @ApiModelProperty(value = "整车端辅件 3 继电器触点状态 0： Reserved 1： Opend")
    private Integer accessoryThreeTouchState;

    @ApiModelProperty(value = "整车端辅件 3 继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer accessoryThreeFaultState;

    @ApiModelProperty(value = "整车端辅件 4 继电器触点状态 0： Reserved 1： Opend")
    private Integer accessoryFourTouchState;

    @ApiModelProperty(value = "整车端辅件 4 继电器故障状态 0:Normal 1:Weld 2:Opened Fault 3:Signal Invalid")
    private Integer accessoryFourFaultState;



    @ApiModelProperty(value = "vin")
    private String vin;

    public BatterySys(List<String> arg1, List<String> arg2) {
        this.life = Integer.parseInt(arg1.get(0));
        this.mainCircleHighVoltage = Integer.parseInt(arg1.get(1));
        this.attach1CircleHighVoltage = Integer.parseInt(arg1.get(2));
        this.attach2CircleHighVoltage = Integer.parseInt(arg1.get(3));
        this.attach3CircleHighVoltage = Integer.parseInt(arg1.get(4));
        this.vehicleSpeed = Integer.parseInt(arg1.get(5));
        this.mainPositiveTouchState = Integer.parseInt(arg1.get(6));
        this.mainPositiveFaultState = Integer.parseInt(arg1.get(7));
        this.mainNagetiveTouchState = Integer.parseInt(arg1.get(8));
        this.mainNagetiveFaultState = Integer.parseInt(arg1.get(9));
        this.chargePositiveTouchState = Integer.parseInt(arg1.get(10));
        this.chargePositiveFaultState = Integer.parseInt(arg1.get(11));
        this.heatPositiveTouchState = Integer.parseInt(arg1.get(12));
        this.heatPositiveFaultState = Integer.parseInt(arg1.get(13));
        this.heatNagetiveTouchState = Integer.parseInt(arg1.get(14));
        this.heatNagetiveFaultState = Integer.parseInt(arg1.get(15));
        this.accessoryOneTouchState = Integer.parseInt(arg1.get(16));
        this.accessoryOneFaultState = Integer.parseInt(arg1.get(17));
        this.accessoryTwoTouchState = Integer.parseInt(arg1.get(18));
        this.accessoryTwoFaultState = Integer.parseInt(arg1.get(19));
        this.accessoryThreeTouchState = Integer.parseInt(arg1.get(20));
        this.accessoryThreeFaultState = Integer.parseInt(arg1.get(21));
        this.accessoryFourTouchState = Integer.parseInt(arg1.get(22));
        this.accessoryFourFaultState = Integer.parseInt(arg1.get(23));

        this.vin = arg2.get(0);
    }

}
