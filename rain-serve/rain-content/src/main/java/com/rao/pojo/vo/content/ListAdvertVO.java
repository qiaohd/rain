package com.rao.pojo.vo.content;

import lombok.Data;

/**
 * C端-广告-视图模型
 *
 * @author raojing
 * @date 2020/4/11 11:23
 */
@Data
public class ListAdvertVO {

    /**
     * 图片
     */
    private String imageUrl;

    /**
     * 文章类型 1:链接 2：文章详情 3：无跳转
     */
    private Integer adType;

    /**
     * 文章内容 文章类型 1-链接 2-文章ID 3-无
     */
    private String adContent;

}
