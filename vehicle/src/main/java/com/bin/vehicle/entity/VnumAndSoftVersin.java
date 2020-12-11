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
@ApiModel(value="VnumAndSoftVersin对象", description="")
public class VnumAndSoftVersin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "车辆编号1")
    private String vehicleNo1;

    @ApiModelProperty(value = "车辆编号2")
    private String vehicleNo2;

    @ApiModelProperty(value = "车辆编号3")
    private String vehicleNo3;

    @ApiModelProperty(value = "车辆编号4")
    private String vehicleNo4;

    @ApiModelProperty(value = "车辆编号5")
    private String vehicleNo5;

    @ApiModelProperty(value = "软件版本")
    private String softVersion;

    @ApiModelProperty(value = "硬件版本")
    private String hardVersion;

    public VnumAndSoftVersin(List<String> args) {
        this.vehicleNo1 = args.get(0);
        this.vehicleNo2 = args.get(1);
        this.vehicleNo3 = args.get(2);
        this.vehicleNo4 = args.get(3);
        this.vehicleNo5 = args.get(4);
        this.softVersion = args.get(5);
        this.hardVersion = args.get(6);

    }
}
