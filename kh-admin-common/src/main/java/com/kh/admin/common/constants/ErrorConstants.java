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
     * 支付中状态
     */
    String USER_PAYING_CODE = "100";
    String USER_PAYING_MSG = "用户正在支付中。。。";

    /**
     * 无效签名
     */
    String INVALID_SIGN_CODE = "-100";
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

    /**
     * 平台方错误
     */
    String PLATFORM_ERROR_CODE = "-300";
    String PLATFORM_ERROR_MSG = "平台方错误";

    /**
     * 支付失败
     */
    String PAY_ERROR_CODE = "-301";
    String PAY_ERROR_MSG = "支付失败";

    /**
     * 退款失败
     */
    String REFUND_ERROR_CODE = "-302";
    String REFUND_ERROR_MSG = "退款失败";

    /**
     * 清算方无效
     */
    String INVALID_LIQUIDATOR_CODE = "-201";
    String INVALID_LIQUIDATOR_MSG = "清算方无效";

    /**
     * 商户无效
     */
    String INVALID_STORE_CODE = "-202";
    String INVALID_STORE_MSG = "商户无效";

    /**
     * 子商户号无效
     */
    String INVALID_SUB_MCH_CODE = "-203";
    String INVALID_SUB_MCH_MSG = "子商户号无效";

    /**
     * 门店无效
     */
    String INVALID_SHOP_CODE = "-204";
    String INVALID_SHOP_MSG = "门店无效";

    /**
     * 渠道号无效
     */
    String INVALID_CHANNEL_CODE = "-205";
    String INVALID_CHANNEL_MSG = "渠道号无效";

    /**
     * 重复订单号
     */
    String INVALID_REPEAT_ORDER_CODE = "-206";
    String INVALID_REPEAT_ORDER_MSG = "重复订单号";

    /**
     * 订单不存在
     */
    String NOT_EXIST_ORDER_CODE = "-207";
    String NOT_EXIST_ORDER_MSG = "订单不存在";

    /**
     * 支付平台无效
     */
    String INVALID_PLATFORM_CODE = "-208";
    String INVALID_PLATFORM_MSG = "支付平台无效";

    /**
     * 文件未生成
     */
    String NOT_GENERATE_FILE_CODE = "-209";
    String NOT_GENERATE_FILE_MSG = "文件未生成";

    /**
     * 文件类型错误
     */
    String FILE_TYPE_ERROR_CODE = "-210";
    String FILE_TYPE_ERROR_MSG = "文件类型错误";

    /**
     * 无效费率
     */
    String INVALID_RATE_CODE = "-211";
    String INVALID_RATE_MSG = "无效费率";

    /**
     * 费率类型错误
     */
    String RATE_TYPE_ERROR_CODE = "-212";
    String RATE_TYPE_ERROR_MSG = "费率类型错误";

    /**
     * 未开通见证宝
     */
    String NOT_OPEN_WITNESS_CODE = "-213";
    String NOT_OPEN_WITNESS_MSG = "未开通见证宝";

    /**
     * 重复绑卡
     */
    String REPEAT_BIND_DANK_CODE = "-214";
    String REPEAT_BIND_DANK_MSG = "重复绑卡";

    /**
     * 暂未绑卡
     */
    String NOT_BIND_BANK_CODE = "-215";
    String NOT_BIND_BANK_MSG = "暂未绑卡";

    /**
     * 余额不足
     */
    String BALANCE_NOT_ENOUGH_CODE = "-216";
    String BALANCE_NOT_ENOUGH__MSG = "余额不足";

    /**
     * 单笔登记挂账记录不存在
     */
    String NOT_SINGLE_ALLOCATE_CODE = "-217";
    String NOT_SINGLE_ALLOCATE_MSG = "单笔登记挂账记录不存在";

    /**
     * 提现记录不存在
     */
    String NOT_WITHDRAW_CODE = "-218";
    String NOT_WITHDRAW_MSG = "提现记录不存在";

    /**
     * 转账记录不存在
     */
    String NOT_TRANSFER_CODE = "-219";
    String NOT_TRANSFER_MSG = "转账记录不存在";

    /**
     * 无效操作
     */
    String INVALID_OPERATION_CODE = "-220";
    String INVALID_OPERATION_MSG = "无效操作";

    /**
     * 请求过于频繁，请稍候重试
     */
    String FREQUENT_REQUESTS_CODE = "-221";
    String FREQUENT_REQUESTS_MSG = "请求过于频繁，请稍候重试";

    /**
     * 支付类型错误
     */
    String PAY_TYPE_ERROR_CODE = "-222";
    String PAY_TYPE_ERROR_MSG = "支付类型错误";

    /**
     * 解析错误
     */
    String PARSE_ERROR_CODE = "-223";
    String PARSE_ERROR_MSG = "解析错误";

}
