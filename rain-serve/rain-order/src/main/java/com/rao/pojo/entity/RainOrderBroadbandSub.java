package com.rao.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 *宽带订单副表
 *
 * @author raojing
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RainOrderBroadbandSub {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @Id
    private Long orderId;

    /**
     * 交易方式 1-线上交易 2-线下交易
     */
    @Column(name = "trade_type")
    private Integer tradeType;

    /**
     * 学校ID
     */
    @Column(name = "campus_id")
    private Long campusId;

    /**
     * 学校名称
     */
    @Column(name = "campus_name")
    private String campusName;

    /**
     * 院系ID
     */
    @Column(name = "faculty_id")
    private Long facultyId;

    /**
     * 院系名称
     */
    @Column(name = "faculty_name")
    private String facultyName;

    /**
     * 专业名称
     */
    @Column(name = "major_name")
    private String majorName;

    /**
     * 年级-枚举
     */
    @Column(name = "grade")
    private Integer grade;

    /**
     * 小程序码-图片
     */
    @Column(name = "qr_code_image")
    private String qrCodeImage;

    /**
     * 交易码
     */
    @Column(name = "trade_code")
    private String tradeCode;

    /**
     * 受理时间
     */
    @Column(name = "dispose_time")
    private Date disposeTime;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 完成时间
     */
    @Column(name = "complete_time")
    private Date completeTime;


}
