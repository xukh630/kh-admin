/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.common.result;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kh.admin.common.constants.ErrorConstants;
import org.apache.commons.lang3.StringUtils;


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
        this.returnValue = returnValue;
        this.isSuccess= true;
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
     */
    public static <T>  ResultModle<T> success(T returnValue) {
        return new  ResultModle<T> (returnValue);
    }

    /**
     * 定制错误信息
     */
    public static <T> ResultModle<T> customError(String errorCode, String errorMessage) {
        return new ResultModle(errorCode, errorMessage);
    }

    /**
     * 100 = 支付中
     */
    public static <T> ResultModle<T> userPaying(){
        return new ResultModle(ErrorConstants.USER_PAYING_CODE, ErrorConstants.USER_PAYING_MSG);
    }

    /**
     * -100 = 无效签名
     */
    public static <T> ResultModle<T> signError(){
        return new ResultModle(ErrorConstants.INVALID_SIGN_CODE, ErrorConstants.INVALID_SIGN_MSG);
    }

    /**
     * -101 = 无效参数
     */
    public static <T> ResultModle<T> paramError(){
        return new ResultModle(ErrorConstants.INVALID_PARAM_CODE, ErrorConstants.INVALID_PARAM_MSG);
    }

    /**
     * -101 = 无效参数
     */
    public static <T> ResultModle<T> paramError(String column){
        if(StringUtils.isBlank(column)){
            return new ResultModle(ErrorConstants.INVALID_PARAM_CODE, ErrorConstants.INVALID_PARAM_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_PARAM_CODE, ErrorConstants.INVALID_PARAM_MSG + " >> " + column);
        }
    }

    /**
     * -102 = 权限不足
     */
    public static <T> ResultModle<T> perssionError(){
        return new ResultModle(ErrorConstants.PERMISSION_DENIED_CODE, ErrorConstants.PERMISSION_DENIED_MSG);
    }

    /**
     * -103 = 通用错误
     */
    public static <T> ResultModle<T> commonError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.COMMON_ERROR_CODE, ErrorConstants.COMMON_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.COMMON_ERROR_CODE, msg);
        }
    }

    /**
     * -104 = 登录失效
     */
    public static <T> ResultModle<T> loginError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.INVALID_LOGIN_CODE, ErrorConstants.INVALID_LOGIN_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_LOGIN_CODE, ErrorConstants.INVALID_LOGIN_MSG + ">>" + msg);
        }
    }

    /**
     * -200 = 服务器异常
     */
    public static <T> ResultModle<T> serverError(){
        return new ResultModle(ErrorConstants.SERVER_ERROR_CODE, ErrorConstants.SERVER_ERROR_MSG);
    }

    public static <T> ResultModle<T> serverError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.SERVER_ERROR_CODE, ErrorConstants.SERVER_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.SERVER_ERROR_CODE, ErrorConstants.SERVER_ERROR_MSG+ " >> " + msg);
        }
    }

    /**
     * -300 = 平台方错误
     */
    public static <T> ResultModle<T> platformError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.PLATFORM_ERROR_CODE, ErrorConstants.PLATFORM_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.PLATFORM_ERROR_CODE, ErrorConstants.PLATFORM_ERROR_MSG+ " >> " + msg);
        }
    }

    /**
     * -301 = 支付失败
     */
    public static <T> ResultModle<T> payError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.PAY_ERROR_CODE, ErrorConstants.PAY_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.PAY_ERROR_CODE, ErrorConstants.PAY_ERROR_MSG+ " >> " + msg);
        }
    }

    /**
     * -302 = 退款失败
     */
    public static <T> ResultModle<T> refundError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.REFUND_ERROR_CODE, ErrorConstants.REFUND_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.REFUND_ERROR_CODE, ErrorConstants.REFUND_ERROR_MSG+ " >> " + msg);
        }
    }

    /**
     * -201 = 清算方无效
     */
    public static <T> ResultModle<T> liquidatorError(String liquidatorId){
        if(StringUtils.isBlank(liquidatorId)){
            return new ResultModle(ErrorConstants.INVALID_LIQUIDATOR_CODE, ErrorConstants.INVALID_LIQUIDATOR_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_LIQUIDATOR_CODE, ErrorConstants.INVALID_LIQUIDATOR_MSG + " >> " + liquidatorId);
        }
    }

    /**
     * -202 = 商户无效
     */
    public static <T> ResultModle<T> storeError(String storeId){
        if(StringUtils.isBlank(storeId)){
            return new ResultModle(ErrorConstants.INVALID_STORE_CODE, ErrorConstants.INVALID_STORE_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_STORE_CODE, ErrorConstants.INVALID_STORE_MSG + " >> " + storeId);
        }
    }

    /**
     * -203 = 子商户号无效
     */
    public static <T> ResultModle<T> subMchError(String subMchId){
        if(StringUtils.isBlank(subMchId)){
            return new ResultModle(ErrorConstants.INVALID_SUB_MCH_CODE, ErrorConstants.INVALID_SUB_MCH_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_SUB_MCH_CODE, ErrorConstants.INVALID_SUB_MCH_MSG + " >> " + subMchId);
        }
    }

    /**
     * -204 = 门店无效
     */
    public static <T> ResultModle<T> shopError(String shopId){
        if(StringUtils.isBlank(shopId)){
            return new ResultModle(ErrorConstants.INVALID_SHOP_CODE, ErrorConstants.INVALID_SHOP_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_SHOP_CODE, ErrorConstants.INVALID_SHOP_MSG + " >> " + shopId);
        }
    }

    /**
     * -205 = 渠道号无效
     */
    public static <T> ResultModle<T> channleError(String channleId){
        if(StringUtils.isBlank(channleId)){
            return new ResultModle(ErrorConstants.INVALID_CHANNEL_CODE, ErrorConstants.INVALID_CHANNEL_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_CHANNEL_CODE, ErrorConstants.INVALID_CHANNEL_MSG + " >> " + channleId);
        }
    }

    /**
     * -206 = 重复订单号
     */
    public static <T> ResultModle<T> reOrderError(String orderSn){
        if(StringUtils.isBlank(orderSn)){
            return new ResultModle(ErrorConstants.INVALID_REPEAT_ORDER_CODE, ErrorConstants.INVALID_REPEAT_ORDER_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_REPEAT_ORDER_CODE, ErrorConstants.INVALID_REPEAT_ORDER_MSG + " >> " + orderSn);
        }
    }

    /**
     * -207 = 订单不存在
     */
    public static <T> ResultModle<T> noOrderError(String orderSn){
        if(StringUtils.isBlank(orderSn)){
            return new ResultModle(ErrorConstants.NOT_EXIST_ORDER_CODE, ErrorConstants.NOT_EXIST_ORDER_MSG);
        }else{
            return new ResultModle(ErrorConstants.NOT_EXIST_ORDER_CODE, ErrorConstants.NOT_EXIST_ORDER_MSG + " >> " + orderSn);
        }
    }

    /**
     * -208 = 支付平台无效
     */
    public static <T> ResultModle<T> payPlatformError(String payPlatform){
        if(StringUtils.isBlank(payPlatform)){
            return new ResultModle(ErrorConstants.INVALID_PLATFORM_CODE, ErrorConstants.INVALID_PLATFORM_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_PLATFORM_CODE, ErrorConstants.INVALID_PLATFORM_MSG + " >> " + payPlatform);
        }
    }

    /**
     * -209 = 文件未生成
     */
    public static <T> ResultModle<T> fileError(){
        return new ResultModle(ErrorConstants.NOT_GENERATE_FILE_CODE, ErrorConstants.NOT_GENERATE_FILE_MSG);
    }

    /**
     * -210 = 文件类型错误
     */
    public static <T> ResultModle<T> fileTypeError(String fileType){
        if(StringUtils.isBlank(fileType)){
            return new ResultModle(ErrorConstants.FILE_TYPE_ERROR_CODE, ErrorConstants.FILE_TYPE_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.FILE_TYPE_ERROR_CODE, ErrorConstants.FILE_TYPE_ERROR_MSG + " >> " + fileType);
        }
    }

    /**
     * -211 = 无效费率
     */
    public static <T> ResultModle<T> rateError(){
        return new ResultModle(ErrorConstants.INVALID_RATE_CODE, ErrorConstants.INVALID_RATE_MSG);
    }

    /**
     * -212 = 费率类型错误
     */
    public static <T> ResultModle<T> rateTypeError(String rateType){
        if(StringUtils.isBlank(rateType)){
            return new ResultModle(ErrorConstants.RATE_TYPE_ERROR_CODE, ErrorConstants.RATE_TYPE_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.RATE_TYPE_ERROR_CODE, ErrorConstants.RATE_TYPE_ERROR_MSG + " >> " + rateType);
        }
    }

    /**
     * -213 = 未开通见证宝
     */
    public static <T> ResultModle<T> witnessError(){
        return new ResultModle(ErrorConstants.NOT_OPEN_WITNESS_CODE, ErrorConstants.NOT_OPEN_WITNESS_MSG);
    }

    /**
     * -214 = 重复绑卡
     */
    public static <T> ResultModle<T> reBindError(String bankno){
        if(StringUtils.isBlank(bankno)){
            return new ResultModle(ErrorConstants.REPEAT_BIND_DANK_CODE, ErrorConstants.REPEAT_BIND_DANK_MSG);
        }else{
            return new ResultModle(ErrorConstants.REPEAT_BIND_DANK_CODE, ErrorConstants.REPEAT_BIND_DANK_MSG + " >> " + bankno);
        }
    }

    /**
     * -215 = 暂未绑卡
     */
    public static <T> ResultModle<T> noBindError(){
        return new ResultModle(ErrorConstants.NOT_BIND_BANK_CODE, ErrorConstants.NOT_BIND_BANK_MSG);
    }

    /**
     * -216 = 余额不足
     */
    public static <T> ResultModle<T> balanceError(){
        return new ResultModle(ErrorConstants.BALANCE_NOT_ENOUGH_CODE, ErrorConstants.BALANCE_NOT_ENOUGH__MSG);
    }

    /**
     * -217 = 单笔登记挂账记录不存在
     */
    public static <T> ResultModle<T> allocateError(String allocateId){
        if(StringUtils.isBlank(allocateId)){
            return new ResultModle(ErrorConstants.NOT_SINGLE_ALLOCATE_CODE, ErrorConstants.NOT_SINGLE_ALLOCATE_MSG);
        }else{
            return new ResultModle(ErrorConstants.NOT_SINGLE_ALLOCATE_CODE, ErrorConstants.NOT_SINGLE_ALLOCATE_MSG + " >> " + allocateId);
        }
    }

    /**
     * -218 = 提现记录不存在
     */
    public static <T> ResultModle<T> withdrawError(String withdrawId){
        if(StringUtils.isBlank(withdrawId)){
            return new ResultModle(ErrorConstants.NOT_WITHDRAW_CODE, ErrorConstants.NOT_WITHDRAW_MSG);
        }else{
            return new ResultModle(ErrorConstants.NOT_WITHDRAW_CODE, ErrorConstants.NOT_WITHDRAW_MSG + " >> " + withdrawId);
        }
    }

    /**
     * -219 = 转账记录不存在
     */
    public static <T> ResultModle<T> transferError(String transferId){
        if(StringUtils.isBlank(transferId)){
            return new ResultModle(ErrorConstants.NOT_TRANSFER_CODE, ErrorConstants.NOT_TRANSFER_MSG);
        }else{
            return new ResultModle(ErrorConstants.NOT_TRANSFER_CODE, ErrorConstants.NOT_TRANSFER_MSG + " >> " + transferId);
        }
    }

    /**
     * -220 = 无效操作
     */
    public static <T> ResultModle<T> operError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.INVALID_OPERATION_CODE, ErrorConstants.INVALID_OPERATION_MSG);
        }else{
            return new ResultModle(ErrorConstants.INVALID_OPERATION_CODE, ErrorConstants.INVALID_OPERATION_MSG + " >> " + msg);
        }
    }

    /**
     * -221 = 请求过于频繁，请稍候重试
     */
    public static <T> ResultModle<T> requestError(){
        return new ResultModle(ErrorConstants.FREQUENT_REQUESTS_CODE, ErrorConstants.FREQUENT_REQUESTS_MSG);
    }

    /**
     * -222 = 支付类型错误
     */
    public static <T> ResultModle<T> payTypeError(String payType){
        if(StringUtils.isBlank(payType)){
            return new ResultModle(ErrorConstants.PAY_TYPE_ERROR_CODE, ErrorConstants.PAY_TYPE_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.PAY_TYPE_ERROR_CODE, ErrorConstants.PAY_TYPE_ERROR_MSG + " >> " + payType);
        }
    }

    /**
     * -223 = 解析错误
     */
    public static <T> ResultModle<T> parseError(String msg){
        if(StringUtils.isBlank(msg)){
            return new ResultModle(ErrorConstants.PARSE_ERROR_CODE, ErrorConstants.PARSE_ERROR_MSG);
        }else{
            return new ResultModle(ErrorConstants.PARSE_ERROR_CODE, ErrorConstants.PARSE_ERROR_MSG + " >> " + msg);
        }
    }

    @Override
    public String toString() {
        return "ResultModle{" +
                "isSuccess=" + isSuccess +
                ", returnValue=" + returnValue +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}



