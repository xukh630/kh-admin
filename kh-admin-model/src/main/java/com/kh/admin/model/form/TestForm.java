package com.kh.admin.model.form;

import java.util.TreeMap;

/**
 * 所在的包名: com.kh.admin.model.form
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 11:55 2017/8/7
 */
public class TestForm extends TreeMap<String,String>{

    private String url = "http://qq";

    public String getUrl() {
        return url;
    }

    /* 子商户号或银行识别码 */
    public void setSubMchId(String subMchId) {
        this.put("sub_mch_id", subMchId);
    }

    public String getSubMchId() {
        return this.get("sub_mch_id");
    }

    /* 随机字符串，不长于32位 */
    public void setNonceStr(String nonceStr) {
        this.put("nonce_str", nonceStr);
    }

    public String getNonceStr() {
        return this.get("nonce_str");
    }

    /* 商品描述 */
    public void setBody(String body) {
        this.put("body", body);
    }

    public String getBody() {
        return this.get("body");
    }
}
