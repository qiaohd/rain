package com.rao.pojo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 更新微信资料-数据传输模型
 *
 * @author raojing
 * @date 2020/4/6 17:09
 */
@Data
public class WxProfileDTO {

    /**
     * 微信昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String wxNickname;

    /**
     * 性别 0：未知、1：男、2：女
     */
    @NotNull(message = "性别不能为空")
    @Range(min = 0, max = 2, message = "性别非法")
    private Integer gender;

    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空")
    private String avatar;

}
