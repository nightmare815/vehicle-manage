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
@ApiModel(value="SingleVoltage对象", description="")
public class SingleVoltage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "电压编号")
    private Integer voltageNum;

    @ApiModelProperty(value = "电压值1")
    private Double voltage1;

    @ApiModelProperty(value = "电压值2")
    private Double voltage2;

    @ApiModelProperty(value = "电压值3")
    private Double voltage3;

    public SingleVoltage(List<String> args) {
        this.voltageNum = Integer.parseInt(args.get(0));
        this.voltage1 = Double.parseDouble(args.get(1));
        this.voltage2 = Double.parseDouble(args.get(2));
        this.voltage3 = Double.parseDouble(args.get(3));
    }

}
