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
@ApiModel(value="BatteryStateSix对象", description="")
public class BatteryStateSix implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "最高电压电芯所在 CSC 编号")
    private String highestVoltageCscNum;

    @ApiModelProperty(value = "最高电压电芯在系统中编号")
    private String highestVoltageSysNum;

    @ApiModelProperty(value = "最低电压电芯所在 CSC 编号")
    private String lowestVoltageCscNum;

    @ApiModelProperty(value = "最低电压电芯在系统中编号")
    private String lowestVoltageSysNum;

    public BatteryStateSix(List<String> args) {
        this.highestVoltageCscNum = args.get(0);
        this.highestVoltageSysNum = args.get(1);
        this.lowestVoltageCscNum = args.get(2);
        this.lowestVoltageSysNum = args.get(3);
    }

}
