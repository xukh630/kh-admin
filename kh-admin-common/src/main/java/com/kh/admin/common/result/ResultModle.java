/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.common.result;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kh.admin.common.constants.ErrorConstants;


import java.io.Serializable;

/**
 * 项目：liquidator-platform
 * 包名：com.fshows.liquidator.platform.common.result
 * 功能：返回结果对象
 * 时间：2016-07-28 10:00
 * 作者：Mr.Kiwi
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class ResultModle<T> implements Serializable {

    private static final long serialVersionUID = -9204659000311373130L;
    private boolean           isSuccess;
    private T                 returnValue;
    private String            errorCode;
    private String            errorMessage;

    public ResultModle(T returnValue) {
        this.isSuccess= true;
        this.returnValue = returnValue;
    }

    public ResultModle(String errorCode, String errorMessage) {
        this.isSuccess=false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(T returnValue) {
        this.returnValue = returnValue;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 成功返回
     * @param <T>
     * @return
     */
    public static <T>  ResultModle<T> success(T returnValue) {
        return new  ResultModle<T> (returnValue);
    }

    /**
     * 无效sign
     * @param <T>
     * @return
     */
    public static <T> ResultModle<T> signError(){

        return new ResultModle(ErrorConstants.INVALID_SIGN_CODE, ErrorConstants.INVALID_SIGN_MSG);
    }

    /**
     * 无效参数
     * @param <T>
     * @return
     */
    public static <T> ResultModle<T> paramError(){

        return new ResultModle(ErrorConstants.INVALID_PARAM_CODE, ErrorConstants.INVALID_PARAM_MSG);
    }

    /**
     * 权限不足
     * @param <T>
     * @return
     */
    public static <T> ResultModle<T> perssionError(){

        return new ResultModle(ErrorConstants.PERMISSION_DENIED_CODE, ErrorConstants.PERMISSION_DENIED_MSG);
    }

    /**
     * 定制错误信息
     * @param <T>
     * @return
     */
    public static <T> ResultModle<T> customError(String errorCode, String errorMessage) {
        return new ResultModle(errorCode, errorMessage);
    }

    /**
     * 服务器异常
     * @param <T>
     * @return
     */
    public static <T> ResultModle<T> serverError(){

        return new ResultModle(ErrorConstants.SERVER_ERROR_CODE, ErrorConstants.SERVER_ERROR_MSG);
    }

    /**
     * 通用异常,用于业务错误
     * @param <T>
     * @return
     */
    public static <T> ResultModle<T> commonError(String msg){

        return new ResultModle(ErrorConstants.COMMON_ERROR_CODE, msg);
    }

    public ResultModle() {
    }
}



