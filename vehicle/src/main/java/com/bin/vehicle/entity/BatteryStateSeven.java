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
@ApiModel(value="BatteryStateSeven对象", description="")
public class BatteryStateSeven implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "直流充电 A 枪 DC+温度传感器温度")
    @TableField("DC_agun_dCplus_temp")
    private Integer dcAgunDcplusTemp;

    @ApiModelProperty(value = "直流充电 A 枪 DC-温度传感器温度")
    @TableField("DC_agun_dCsub_temp")
    private Integer dcAgunDcsubTemp;

    @ApiModelProperty(value = "直流充电 B 枪 DC+温度传感器温度")
    @TableField("DC_bgun_dCplus_temp")
    private Integer dcBgunDcplusTemp;

    @ApiModelProperty(value = "直流充电 B 枪 DC-温度传感器温度")
    @TableField("DC_bgun_dCsub_temp")
    private Integer dcBgunDcsubTemp;

    @ApiModelProperty(value = "交流充电 A C+温度传感器温度")
    @TableField("AC_aCplus_temp")
    private Integer acAcplusTemp;

    @ApiModelProperty(value = "交流充电 A C-温度传感器温度")
    @TableField("AC_aCsub_temp")
    private Integer acAcsubTemp;

    public BatteryStateSeven(List<String> args) {
        this.dcAgunDcplusTemp = Integer.parseInt(args.get(0));
        this.dcAgunDcsubTemp = Integer.parseInt(args.get(1));
        this.dcBgunDcplusTemp = Integer.parseInt(args.get(2));
        this.dcBgunDcsubTemp = Integer.parseInt(args.get(3));
        this.acAcplusTemp = Integer.parseInt(args.get(4));
        this.acAcsubTemp = Integer.parseInt(args.get(5));
    }
}
