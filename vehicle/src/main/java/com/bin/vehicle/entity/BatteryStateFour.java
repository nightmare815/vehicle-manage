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
@ApiModel(value="BatteryStateFour对象", description="")
public class BatteryStateFour implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "电芯温度最大值	分辨率1℃/bit	数据范围-40~210")
    private Integer cellMaxTemp;

    @ApiModelProperty(value = "电芯温度最小值	分辨率1℃/bit	数据范围-40~210")
    private Integer cellMinTemp;

    @ApiModelProperty(value = "电芯温度平均值	分辨率1℃/bit	数据范围-40~210")
    private Integer cellAvgTemp;

    @ApiModelProperty(value = "最高温度探针所在 CSC 编号")
    private String highestTempCscNum;

    @ApiModelProperty(value = "最高温度探针在系统中位置")
    private String highestTempSysPosition;

    @ApiModelProperty(value = "最低温度探针所在 CSC 编号")
    private String lowestTempCscNum;

    @ApiModelProperty(value = "最低温度探针在系统中位置")
    private String lowestTempSysPosition;

    public BatteryStateFour(List<String> args) {
        this.cellMaxTemp = Integer.parseInt(args.get(0));
        this.cellMinTemp = Integer.parseInt(args.get(1));
        this.cellAvgTemp = Integer.parseInt(args.get(2));
        this.highestTempCscNum = args.get(3);
        this.highestTempSysPosition = args.get(4);
        this.lowestTempCscNum = args.get(5);
        this.lowestTempSysPosition = args.get(6);
    }
}
