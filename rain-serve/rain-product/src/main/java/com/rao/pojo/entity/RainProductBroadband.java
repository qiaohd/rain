package com.rao.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 *宽带产品
 *
 * @author raojing
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RainProductBroadband {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    private Long id;

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
     * 首页展示图片
     */
    @Column(name = "index_image")
    private String indexImage;

    /**
     * 产品介绍
     */
    @Column(name = "product_introduce")
    private String productIntroduce;

    /**
     * 产品图片-多张以逗号隔开
     */
    @Column(name = "product_images")
    private String productImages;

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
