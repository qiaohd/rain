package com.rao.pojo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 保存学校-数据传输模型
 *
 * @author raojing
 * @date 2020/4/12 0:02
 */
@Data
public class SaveCampusDTO {

    /**
     * 学校名称
     */
    @NotBlank(message = "学校名称不能为空")
    private String campusName;

    /**
     * 学校logo
     */
    @NotBlank(message = "学校logo不能为空")
    private String campusLogo;

    /**
     * 省份code
     */
    @NotBlank(message = "省份code不能为空")
    private String provinceCode;

    /**
     * 城市code
     */
    @NotBlank(message = "城市code不能为空")
    private String cityCode;

    /**
     * 权重
     */
    @NotNull(message = "权重不能为空")
    private Integer weight;

    /**
     * 状态 1-启用 2-禁用
     */
    @Range(min = 1, max = 2, message = "状态值非法")
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 院系id
     */
    @NotEmpty(message = "院系不能为空")
    private List<Long> facultyIds;

}
