package com.rao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 院系列表-视图模型
 *
 * @author raojing
 * @date 2020/4/12 10:10
 */
@Data
public class ListFacultyVO {

    /**
     * id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 院系名称
     */
    private String facultyName;

}
