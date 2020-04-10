package com.rao.pojo.entity.content;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 广告
 *
 * @author raojing
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RainAdvert {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 广告标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 广告位 1：首页bannel  2:个人中心bannel
     */
    @Column(name = "position")
    private Integer position;

    /**
     * 图片
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 1:链接 2：文章详情 3：无跳转
     */
    @Column(name = "ad_type")
    private Integer adType;

    /**
     * 链接的跳转地址
     */
    @Column(name = "ad_url")
    private String adUrl;

    /**
     * 文章id
     */
    @Column(name = "document_id")
    private Long documentId;

    /**
     * 状态 1-上架 2-下架
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

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
