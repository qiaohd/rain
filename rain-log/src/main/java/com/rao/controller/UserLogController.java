package com.rao.controller;

import com.rao.annotation.BeanValid;
import com.rao.constant.permission.log.LogCodeConstant;
import com.rao.pojo.dto.UserLoginLogoutLogDTO;
import com.rao.pojo.vo.UserLoginLogoutLogVO;
import com.rao.service.UserLogService;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import com.rao.util.result.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hudelin
 * @className :UserLogController
 * @description :用户日志
 * @date: 2020-01-13 14:31
 */
@RestController
@RequestMapping("/log/user_login_logout")
public class UserLogController {

    @Autowired
    private UserLogService userLogService;

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('" + LogCodeConstant.LOG_USER_LOGINLOGOUT_LIST + "')")
    public ResultMessage<PageResult<UserLoginLogoutLogVO>> list(PageParam pageParam, @BeanValid @RequestBody UserLoginLogoutLogDTO userLoginLogoutLogDTO) {
        PageResult<UserLoginLogoutLogVO> logoutLogVOPage = userLogService.getLoginLogout(pageParam,userLoginLogoutLogDTO);
        return ResultMessage.success(logoutLogVOPage);
    }
}
