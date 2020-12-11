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
@ApiModel(value="TempInfo对象", description="")
public class TempInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "温度编号")
    private Integer tempNum;

    @ApiModelProperty(value = "温度值1")
    private Integer temperature1;

    @ApiModelProperty(value = "温度值2")
    private Integer temperature2;

    @ApiModelProperty(value = "温度值3")
    private Integer temperature3;

    @ApiModelProperty(value = "温度值4")
    private Integer temperature4;

    @ApiModelProperty(value = "温度值5")
    private Integer temperature5;

    @ApiModelProperty(value = "温度值6")
    private Integer temperature6;

    public TempInfo(List<String> args) {
        this.tempNum = Integer.parseInt(args.get(0));
        this.temperature1 = Integer.parseInt(args.get(1));
        this.temperature2 = Integer.parseInt(args.get(2));
        this.temperature3 = Integer.parseInt(args.get(3));
        this.temperature4 = Integer.parseInt(args.get(4));
        this.temperature5 = Integer.parseInt(args.get(5));
        this.temperature6 = Integer.parseInt(args.get(6));
    }
}
