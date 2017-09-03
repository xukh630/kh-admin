package com.kh.admin.common.enums;

/**
 * 项目：liquidator-platform-admin
 * 包名：com.fshows.liquidator.platform.admin.common.enums
 * 功能：
 * 时间：2016-08-09 10:33
 * 作者：Mr.Kiwi
 */
public enum PayPlatform {

    TOTAL(0),   // 全部类型
    BESTPAY(4), // 电信翼支付
    JD(3),      // 京东
    WX(2),      // 微信
    ALIPAY(1);  // 支付宝

    private int value = 0;

    PayPlatform(int value) {

        this.value = value;
    }

    public static PayPlatform valueOf(int value) { // 手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return TOTAL;
            case 1:
                return ALIPAY;
            case 2:
                return WX;
            case 3:
                return JD;
            case 4:
                return BESTPAY;
            default:
                return ALIPAY;
        }
    }

    public int value() {
        return this.value;
    }

}
