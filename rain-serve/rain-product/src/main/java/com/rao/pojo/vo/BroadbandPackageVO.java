package com.rao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 宽带套餐-视图对象
 *
 * @author raojing
 * @date 2020/4/11 21:43
 */
@Data
public class BroadbandPackageVO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 套餐名称
     */
    private String packageName;

    /**
     * 校园宽带原价
     */
    private BigDecimal campusOriginalPrice;

    /**
     * 校园宽带折扣价
     */
    private BigDecimal campusDiscountPrice;

    /**
     * 家庭宽带原价
     */
    private BigDecimal familyOriginalPrice;

    /**
     * 家庭宽带折扣价
     */
    private BigDecimal familyDiscountPrice;

}
