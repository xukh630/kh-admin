/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.common.result;

/**
 * 项目：liquidator-platform-admin
 * 包名：com.fshows.liquidator.platform.admin.common.result
 * 功能：
 * 时间：2016-08-10 14:35
 * 作者：Mr.Kiwi
 */
public class ValidateResult {

    private boolean isSuccess;
    private String msg;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ValidateResult{" +
            "isSuccess=" + isSuccess +
            ", msg='" + msg + '\'' +
            '}';
    }
}
