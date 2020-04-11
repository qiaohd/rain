package com.rao.pojo.vo.content;

import lombok.Data;

import java.util.Date;

/**
 * 文章列表-视图模型
 *
 * @author raojing
 * @date 2020/4/11 18:28
 */
@Data
public class ListDocumentVO {

    /**
     * id
     */
    private Long id;

    /**
     * 文章名称
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createTime;

}
