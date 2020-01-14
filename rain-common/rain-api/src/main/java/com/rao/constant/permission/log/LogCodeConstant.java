package com.rao.constant.permission.log;

import com.rao.annotation.PermissionDesc;

/**
 * 日志服务-log-权限标识
 * @author raojing
 * @date 2019/12/17 20:17
 */
public interface LogCodeConstant {

    /********************************* 日志服务相关 *********************************/

    /**
     * 用户登录登出
     */
    @PermissionDesc(desc = "用户登录登出日志")
    String LOG_USER_LOGINLOGOUT_LIST = "log:user:loginLogout:list";


    /********************************* 日志服务相关 *********************************/
}
