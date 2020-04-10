package com.rao.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 宽带套餐
 *
 * @author raojing
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RainBroadbandPackage {

    private static final long serialVersionUID = 1L;

    /**
     * 套餐id
     */
    @Id
    private Long id;

    /**
     * 套餐名称
     */
    @Column(name = "package_name")
    private String packageName;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 校园宽带原价
     */
    @Column(name = "campus_original_price")
    private BigDecimal campusOriginalPrice;

    /**
     * 校园宽带折扣价
     */
    @Column(name = "campus_discount_price")
    private BigDecimal campusDiscountPrice;

    /**
     * 家庭宽带原价
     */
    @Column(name = "family_original_price")
    private BigDecimal familyOriginalPrice;

    /**
     * 家庭宽带折扣价
     */
    @Column(name = "family_discount_price")
    private BigDecimal familyDiscountPrice;

    /**
     * 上架状态 1-上架 2-下架
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 权重
     */
    @Column(name = "weight")
    private Integer weight;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;


}
