package com.rao.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 *宽带订单
 *
 * @author raojing
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RainOrderBroadband {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 订单类型 1-校园订单 2-家庭订单
     */
    @Column(name = "order_type")
    private Integer orderType;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户昵称
     */
    @Column(name = "user_nickname")
    private String userNickname;

    /**
     * 产品ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 产品标题
     */
    @Column(name = "product_title")
    private String productTitle;

    /**
     * 产品描述
     */
    @Column(name = "product_desc")
    private String productDesc;

    /**
     * 产品首页展示图片
     */
    @Column(name = "index_image")
    private String indexImage;

    /**
     * 套餐ID
     */
    @Column(name = "package_id")
    private Long packageId;

    /**
     * 套餐名称
     */
    @Column(name = "package_name")
    private String packageName;

    /**
     * 原价
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 折扣价
     */
    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    /**
     * 订单状态 1-待受理 2-受理中 3-已完成
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 支付状态 1-已支付 2-未支付
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 下单人名字
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 下单人手机号码
     */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /**
     * 下单人详细地址
     */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /**
     * 预约日期
     */
    @Column(name = "reserve_date")
    private Date reserveDate;

    /**
     * 下单时间
     */
    @Column(name = "create_time")
    private Date createTime;


}
