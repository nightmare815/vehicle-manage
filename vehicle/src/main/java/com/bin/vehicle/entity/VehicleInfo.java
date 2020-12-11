package com.bin.vehicle.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

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
 * @since 2020-12-09
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VehicleInfo对象", description="")
public class VehicleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "汽车vin")
    @TableId(value = "vin", type = IdType.ID_WORKER_STR)
    private String vin;

    @ApiModelProperty(value = "汽车名字")
    private String vehicleName;

    @ApiModelProperty(value = "车型")
    private String vehicleType;

    @ApiModelProperty(value = "车厂")
    private String factory;

    @ApiModelProperty(value = "车主姓名")
    private String vehicleMaster;

    @ApiModelProperty(value = "车牌")
    private String license;

    @ApiModelProperty(value = "车主手机号")
    private String masterPhone;

    @ApiModelProperty(value = "车所在区域")
    private String region;

    @ApiModelProperty(value = "纬度")
    private Double lat;

    @ApiModelProperty(value = "经度")
    private Double lng;

    @ApiModelProperty(value = "车辆行驶状态,0离线1在线2行驶中")
    private Integer driveStatus;

    @ApiModelProperty(value = "当前车速")
    private Double speed;

    @ApiModelProperty(value = "车辆当前位置")
    private String location;

    @ApiModelProperty(value = "终端号")
    private String terminalNum;

    @ApiModelProperty(value = "电机号")
    private String motorNumber;

    @ApiModelProperty(value = "组别")
    private String groupIn;

    @ApiModelProperty(value = "生产日期")
    private Date produceTime;

    @ApiModelProperty(value = "iccid")
    private String iccid;

    @TableLogic
    @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建日期")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改日期")
    private Date gmtModified;


}
