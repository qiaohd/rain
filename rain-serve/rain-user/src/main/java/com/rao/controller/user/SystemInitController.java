package com.rao.controller.user;

import com.rao.annotation.IgnoreTokenAuth;
import com.rao.annotation.SimpleValid;
import com.rao.service.user.SystemInitService;
import com.rao.util.result.ResultMessage;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 系统初始化 controller
 *
 * @author raojing
 * @date 2019/12/8 23:30
 */
@RestController
@RequestMapping("/init")
public class SystemInitController {

    @Resource
    private SystemInitService systemInitService;

    /**
     * 系统初始化
     *
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping("/system")
    public ResultMessage systemInit(@SimpleValid @NotBlank(message = "手机号码不能为空") @RequestParam String phone) {
        systemInitService.systemInit(phone);
        return ResultMessage.success().message("系统初始化成功");
    }

    /**
     * 初始化会员角色
     *
     * @param userId
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping("/member_role")
    public ResultMessage initMemberRole(@SimpleValid @NotNull(message = "用户id不能为空") @RequestParam("userId") Long userId) {
        systemInitService.initMemberRole(userId);
        return ResultMessage.success().message("会员权限初始化成功");
    }

}
