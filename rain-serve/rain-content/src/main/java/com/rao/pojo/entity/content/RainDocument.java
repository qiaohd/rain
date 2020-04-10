package com.rao.pojo.entity.content;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 文章
 *
 * @author raojing
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RainDocument {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 文章名称
     */
    @Column(name = "title")
    private String title;

    /**
     * 文章类型 1-关于我们 8-其他
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 状态 1-上架 2-下架
     */
    @Column(name = "status")
    private Integer status;

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
