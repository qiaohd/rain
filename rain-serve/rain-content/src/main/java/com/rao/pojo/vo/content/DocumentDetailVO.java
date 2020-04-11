package com.rao.pojo.vo.content;

import lombok.Data;

import java.util.Date;

/**
 * 文章详情-视图模型
 *
 * @author raojing
 * @date 2020/4/11 18:13
 */
@Data
public class DocumentDetailVO {

    /**
     * 文章名称
     */
    private String title;

    /**
     * 内容
     */
    private String content;

}
