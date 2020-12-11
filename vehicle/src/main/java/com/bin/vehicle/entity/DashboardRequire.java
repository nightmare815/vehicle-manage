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
@ApiModel(value="DashboardRequire对象", description="")
public class DashboardRequire implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "制动踏板故障状态	0：正常  1：故障")
    private Integer breakBoardFaultState;

    @ApiModelProperty(value = "加速踏板故障状态	0：正常  1：故障")
    private Integer accelerateBoardFaultState;

    @ApiModelProperty(value = "档位器故障状态	0：正常  1：故障")
    private Integer shifterFaultState;

    @ApiModelProperty(value = "换挡是否成功	0：不换挡	1：换挡中	2：换挡成功	3：换挡失败")
    private Integer shiftIsSucceed;

    @ApiModelProperty(value = "当前档位模式	当前档位模式：	0：N挡	1：倒挡（R）	2：前进挡（D）	3：手动挡（M）	4：手动挡升挡（+）	5：手动挡降挡（-）")
    private Integer shiftMode;

    @ApiModelProperty(value = "手自动模式	0：手动	1：自动")
    private Integer manualAutoMode;

    @ApiModelProperty(value = "Ready状态	0：未Ready	1：Ready")
    private Integer readyState;

    @ApiModelProperty(value = "蓄电池故障状态	0：正常	1：欠压")
    private Integer batteryFaultState;

    @ApiModelProperty(value = "当前挡位状态	当前挡位状态：	0000:空挡；	0001:低挡；	0010:高挡；")
    private Integer shiftState;

    @ApiModelProperty(value = "钥匙状态	000：KEY_OFF  	001：KEY_ACC	010：KEY_ON    	011：KEY_START")
    private Integer keyState;

    @ApiModelProperty(value = "行车模式	0：正常	1：小坡	2：大坡")
    private Integer driverMode;

    @ApiModelProperty(value = "电机转速	（注：电机正转为正值，反转为负值）	分辨率：1RPM	偏移量：-4000	范围：-4000-4000")
    private Integer motorSpeed;




    @ApiModelProperty(value = "整车故障等级	0：无故障	1：一级故障	2：二级故障	3：三级故障")
    private Integer vehicleFaultLevel;

    @ApiModelProperty(value = "BMS故障等级	0：无故障	1：一级故障	2：二级故障	3：三级故障")
    private Integer bmsFaultLevel;

    @ApiModelProperty(value = "MCU故障等级	0：无故障	1：一级故障	2：二级故障	3：三级故障")
    private Integer mcuFaultLevel;

    @ApiModelProperty(value = "辅件故障等级	0：无故障	1：一级故障	2：二级故障	3：三级故障")
    private Integer attachFaultLevel;

    @ApiModelProperty(value = "整车故障代码	分辨率1/bit	偏移量 0	范围0-255")
    private Integer vehicleFaultCode;

    public DashboardRequire(List<String> args1, List<String> args2) {
        this.breakBoardFaultState = Integer.parseInt(args1.get(0));
        this.accelerateBoardFaultState = Integer.parseInt(args1.get(1));
        this.shifterFaultState = Integer.parseInt(args1.get(2));
        this.shiftIsSucceed = Integer.parseInt(args1.get(3));
        this.shiftMode = Integer.parseInt(args1.get(4));
        this.manualAutoMode = Integer.parseInt(args1.get(5));
        this.readyState = Integer.parseInt(args1.get(6));
        this.batteryFaultState = Integer.parseInt(args1.get(7));
        this.shiftState = Integer.parseInt(args1.get(8));
        this.keyState = Integer.parseInt(args1.get(9));
        this.driverMode = Integer.parseInt(args1.get(10));
        this.motorSpeed = Integer.parseInt(args1.get(11));

        this.vehicleFaultLevel = Integer.parseInt(args2.get(0));
        this.bmsFaultLevel = Integer.parseInt(args2.get(1));
        this.mcuFaultLevel = Integer.parseInt(args2.get(2));
        this.attachFaultLevel = Integer.parseInt(args2.get(3));
        this.vehicleFaultCode = Integer.parseInt(args2.get(4));
    }

}
