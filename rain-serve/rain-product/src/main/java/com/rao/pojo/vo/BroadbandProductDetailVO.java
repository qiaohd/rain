package com.rao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * 宽带产品详情
 *
 * @author raojing
 * @date 2020/4/11 21:34
 */
@Data
public class BroadbandProductDetailVO {

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
     * 产品介绍
     */
    private String productIntroduce;

    /**
     * 产品图片
     */
    private List<String> productImages;

    /**
     * 套餐列表
     */
    private List<BroadbandPackageVO> packages;

}
