package com.kh.admin.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 项目：fs_liquidator_platform_openapi
 * 包名：com.fshows.liquidator.platform.openapi.common.utils
 * 功能：
 * 时间：2016-08-27
 * 作者：呱牛
 */
public class RequestHandler {

    /**
     * Token获取网关地址
     */
    private String tokenUrl;
    /**
     * 预支付网关url地址
     */
    private String gateUrl;
    /**
     * 查询支付通知网关URL
     */
    private String notifyUrl;
    /**
     * 商户参数
     */
    private String appid;
    private String appkey;
    private String partnerkey;
    private String appsecret;
    private String key;
    /**
     * 请求的参数
     */
    private SortedMap parameters;
    /**
     * Token
     */
    private String Token;
    private String charset;
    /**
     * debug信息
     */
    private String debugInfo;
    private String last_errcode;

    private HttpServletRequest request;

    private HttpServletResponse response;

    /**
     * 初始构造函数。
     *
     * @return
     */
    public RequestHandler(HttpServletRequest request,
                          HttpServletResponse response) {
        this.last_errcode = "0";
        this.request = request;
        this.response = response;
        this.charset = "GBK";
        this.parameters = new TreeMap();
        // 验证notify支付订单网关
        notifyUrl = "https://gw.tenpay.com/gateway/simpleverifynotifyid.xml";

    }

    /**
     * 初始化函数。
     */
    public void init(String app_id, String app_secret, String app_key,
                     String partner_key) {
        this.last_errcode = "0";
        this.Token = "token_";
        this.debugInfo = "";
        this.appkey = app_key;
        this.appid = app_id;
        this.partnerkey = partner_key;
        this.appsecret = app_secret;
    }

    public void init() {
    }

    /**
     * 获取最后错误号
     */
    public String getLasterrCode() {
        return last_errcode;
    }

    /**
     * 获取入口地址,不包含参数值
     */
    public String getGateUrl() {
        return gateUrl;
    }

    /**
     * 获取参数值
     *
     * @param parameter 参数名称
     * @return String
     */
    public String getParameter(String parameter) {
        String s = (String) this.parameters.get(parameter);
        return (null == s) ? "" : s;
    }

    /**
     * 设置参数值
     *
     * @param parameter      参数名称
     * @param parameterValue 参数值
     */

    public void setParameter(String parameter, String parameterValue) {

        String v = "";

        if (null != parameterValue) {

            v = parameterValue.trim();

        }
        this.parameters.put(parameter, v);

    }

    //设置密钥

    public void setKey(String key) {
        this.partnerkey = key;
    }

    //设置微信密钥
    public void setAppKey(String key) {
        this.appkey = key;
    }

    // 特殊字符处理
    public String UrlEncode(String src) throws UnsupportedEncodingException {
        return URLEncoder.encode(src, this.charset).replace("+", "%20");
    }

    // 获取package的签名包
    public String genPackage(SortedMap<String, String> packageParams)
            throws UnsupportedEncodingException {
        String sign = createSign(packageParams);

        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            sb.append(k + "=" + UrlEncode(v) + "&");
        }

        // 去掉最后一个&
        String packageValue = sb.append("sign=" + sign).toString();
        return packageValue;
    }

    /**
     * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     */
    public String createSign(SortedMap<String, String> packageParams) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=").append("1234567890qwertyuiopasdfghjklzxc");
        // 算出摘要
        String enc = TenpayUtil.getCharacterEncoding(this.request, this.response);
        String sign = MD5Util.MD5Encode(sb.toString(), enc).toUpperCase();

        return sign;

    }

    /**
     * 创建package签名
     */
    public boolean createMd5Sign(String signParams) {
        StringBuffer sb = new StringBuffer();
        Set es = this.parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }

        // 算出摘要
        String enc = TenpayUtil.getCharacterEncoding(this.request,
                this.response);
        String sign = MD5Util.MD5Encode(sb.toString(), enc).toLowerCase();

        String tenpaySign = this.getParameter("sign").toLowerCase();

        // debug信息
        this.setDebugInfo(sb.toString() + " => sign:" + sign + " tenpaySign:"
                + tenpaySign);

        return tenpaySign.equals(sign);
    }

    public String getRequestURL() throws UnsupportedEncodingException {

        this.createSign();

        StringBuffer sb = new StringBuffer();

        sb.append("<xml>");

        String enc = TenpayUtil.getCharacterEncoding(this.request, this.response);

        Set es = this.parameters.entrySet();

        Iterator it = es.iterator();

        while (it.hasNext()) {

            Map.Entry entry = (Map.Entry) it.next();

            String k = (String) entry.getKey();

            String v = (String) entry.getValue();

            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {

                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");

            } else {

                sb.append("<" + k + ">" + v + "</" + k + ">");

            }

        }

        sb.append("</xml>");

        return sb.toString();

    }

    protected void createSign() {

        StringBuffer sb = new StringBuffer();

        Set es = this.parameters.entrySet();

        Iterator it = es.iterator();

        while (it.hasNext()) {

            Map.Entry entry = (Map.Entry) it.next();

            String k = (String) entry.getKey();

            String v = (String) entry.getValue();

            if (null != v && !"".equals(v)

                    && !"sign".equals(k) && !"key".equals(k)) {

                sb.append(k + "=" + v + "&");

            }

        }

        sb.append("key=").append("1234567890qwertyuiopasdfghjklzxc"); //自己的API密钥

        String enc = TenpayUtil.getCharacterEncoding(this.request, this.response);

        String sign = MD5Util.MD5Encode(sb.toString(), enc).toUpperCase();

        this.setParameter("sign", sign);

    }

    //输出XML
    public String parseXML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = this.parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"appkey".equals(k)) {

                sb.append("<" + k + ">" + getParameter(k) + "</" + k + ">\n");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 设置debug信息
     */
    protected void setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
    }

    public void setPartnerkey(String partnerkey) {
        this.partnerkey = partnerkey;
    }

    public String getDebugInfo() {
        return debugInfo;
    }

    public String getKey() {
        return key;
    }

    public static String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
    }
}