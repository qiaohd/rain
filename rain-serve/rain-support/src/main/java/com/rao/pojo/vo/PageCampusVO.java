package com.rao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * 学校列表-视图模型
 *
 * @author raojing
 * @date 2020/4/12 0:06
 */
@Data
public class PageCampusVO {

    /**
     * id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 学校名称
     */
    private String campusName;

    /**
     * 学校logo
     */
    private String campusLogo;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 状态 1-启用 2-禁用
     */
    private Integer status;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 创建时间
     */
    private Date createTime;

}
