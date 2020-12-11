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
@ApiModel(value="PowerCountInfo对象", description="")
public class PowerCountInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "累计充电电量	分辨率1kWh/bit")
    private Integer totalChargeCount;

    @ApiModelProperty(value = "累计放电电量	分辨率1kWh/bit")
    private Integer totalDischargeCount;

    @ApiModelProperty(value = "单次充电电量")
    private Double singleChargeCount;

    public PowerCountInfo(List<String> args) {
        this.totalChargeCount = Integer.parseInt(args.get(0));
        this.totalDischargeCount = Integer.parseInt(args.get(1));
        this.singleChargeCount = Double.parseDouble(args.get(2));
    }

}
