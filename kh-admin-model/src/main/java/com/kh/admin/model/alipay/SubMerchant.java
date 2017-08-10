/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.model.alipay;

import com.alipay.api.AlipayObject;

/**
 * 项目：saledian-merchant
 * 包名：com.fshows.saledian.merchant.model.alipay.params
 * 功能：参数对像
 * 时间：2016-07-11 21:58
 * 作者：Mr.Kiwi
 */
public class SubMerchant extends AlipayObject {

    private static final long serialVersionUID = -4867310512191829475L;

    private String merchant_id;

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }
}
