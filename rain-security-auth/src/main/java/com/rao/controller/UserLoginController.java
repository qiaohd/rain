package com.rao.controller;

import com.rao.annotation.BeanValid;
import com.rao.annotation.IgnoreTokenAuth;
import com.rao.annotation.SimpleParam;
import com.rao.dto.WxUserInfo;
import com.rao.pojo.dto.*;
import com.rao.pojo.vo.LoginSuccessVO;
import com.rao.service.LoginService;
import com.rao.service.UserService;
import com.rao.util.result.ResultMessage;
import com.rao.util.wx.WxAppletUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录管理
 * @author raojing
 * @date 2019/12/2 14:14
 */
@RestController
public class UserLoginController {

    @Resource
    private LoginService loginService;
    @Resource    
    private UserService userService;


    /**
     * 用户账号密码登录
     * @param passwordLoginDTO
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping(value = "/login/pwd")
    public ResultMessage<LoginSuccessVO> loginSystemUser(@BeanValid @RequestBody PasswordLoginDTO passwordLoginDTO) {
        LoginSuccessVO loginSuccessVO = loginService.pwdLogin(passwordLoginDTO);
        return ResultMessage.success(loginSuccessVO).message("登录成功");
    }

    /**
     * 用户短信验证码登录
     * @param smsCodeLoginDTO
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping(value = "/login/sms_code")
    public ResultMessage<LoginSuccessVO> smsCodeLoginSystemUser(@BeanValid @RequestBody SmsCodeLoginDTO smsCodeLoginDTO){
        LoginSuccessVO loginSuccessVO = loginService.smsCodeLogin(smsCodeLoginDTO);
        return ResultMessage.success(loginSuccessVO).message("登录成功");
    }

    /**
     * 用户登录微信第三方登录
     * @param wxLoginDTO
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping(value = "/login/wx")
    public ResultMessage wxLoginCUser(@BeanValid @RequestBody WxLoginDTO wxLoginDTO){
        LoginSuccessVO loginSuccessVO = loginService.wxLogin(wxLoginDTO);
        return ResultMessage.success(loginSuccessVO).message("登录成功");
    }

    /**
     * 刷新token
     * @param refreshTokenDTO
     * @return
     */
    @PostMapping(value = "/refresh_token")
    public ResultMessage<LoginSuccessVO> refreshToken(@BeanValid @RequestBody RefreshTokenDTO refreshTokenDTO){
        LoginSuccessVO loginSuccessVO = loginService.refreshToken(refreshTokenDTO);
        return ResultMessage.success(loginSuccessVO).message("令牌刷新成功");
    }

    /**
     * 检查账号（验证码发送前校验）
     * @param smsSendDTO
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping(value = "/check_account")
    public ResultMessage checkAccount(@BeanValid @RequestBody SmsSendDTO smsSendDTO){
        userService.checkAccount(smsSendDTO);
        return ResultMessage.success();
    }

    /**
     * 注销
     * @return
     */
    @PostMapping(value = "/user/logout")
    public ResultMessage logout(){
        loginService.logout();
        return ResultMessage.success().message("用户注销成功");
    }

    /**
     * 测试微信解密用户信息api
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @return
     */
    @IgnoreTokenAuth
    @PostMapping(value = "/test_wx_api")
    public ResultMessage testWxApi(@SimpleParam String encryptedData, @SimpleParam String sessionKey, @SimpleParam String iv){
        WxUserInfo userInfo = WxAppletUtils.getUserInfo(encryptedData, sessionKey, iv);
        return ResultMessage.success(userInfo);
    }
    
}
