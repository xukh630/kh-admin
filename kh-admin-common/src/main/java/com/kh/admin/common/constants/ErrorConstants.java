/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.common.constants;

/**
 * 项目：liquidator-platform-admin
 * 包名：com.fshows.liquidator.platform.admin.common.constants
 * 功能：返回错误的常量
 * 时间：2016-08-02 16:16
 * 作者：Mr.Kiwi
 */
public interface ErrorConstants {

    /**
     * 无效sign
     */
    String  INVALID_SIGN_CODE = "-100";
    String INVALID_SIGN_MSG = "无效签名";

    /**
     * 无效参数
     */
    String INVALID_PARAM_CODE = "-101";
    String INVALID_PARAM_MSG = "无效参数";

    /**
     * 权限不足
     */
    String PERMISSION_DENIED_CODE = "-102";
    String PERMISSION_DENIED_MSG = "权限不足";

    /**
     * 通用错误
     */
    String COMMON_ERROR_CODE = "-103";
    String COMMON_ERROR_MSG = "通用错误";

    /**
     * 登录失效
     */
    String INVALID_LOGIN_CODE = "-104";
    String INVALID_LOGIN_MSG = "登录失效";

    /**
     * 服务器异常
     */
    String SERVER_ERROR_CODE = "-200";
    String SERVER_ERROR_MSG = "服务器异常";
}
