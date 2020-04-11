package com.rao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 产品-视图对象
 *
 * @author raojing
 * @date 2020/4/11 20:50
 */
@Data
public class BroadbandProductVO {

    /**
     * id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 产品标题
     */
    private String productTitle;

    /**
     * 产品描述
     */
    private String productDesc;

    /**
     * 首页展示图片
     */
    private String indexImage;

}
