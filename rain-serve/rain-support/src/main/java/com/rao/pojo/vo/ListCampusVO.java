package com.rao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 学校列表-视图模型
 *
 * @author raojing
 * @date 2020/4/12 10:08
 */
@Data
public class ListCampusVO {

    /**
     * id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    /**
     * 学校名称
     */
    private String campusName;

}
