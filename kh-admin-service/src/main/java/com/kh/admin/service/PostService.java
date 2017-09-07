package com.kh.admin.service;/**
 * Created by Administrator on 2017/7/28.
 */

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.kh.admin.common.result.ResultModle;
import com.kh.admin.common.utils.HttpUtil;
import com.kh.admin.model.alipay.SubMerchant;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.testng.collections.Maps;

import java.io.IOException;
import java.util.Map;

/**
 * @author xukh
 * @create 2017-07-28-9:29
 */
@Service
public class PostService {

    String url = "https://openapi-liquidation-test.51fubei.com/gateway"; //请求地址
    String urld= "http://www.alipaytech.com.cn/alimock-web-gateway/mock/gateway.do";
    String privateKey = "MIICXQIBAAKBgQCrT6NWNGj21BswfIZRx3KCothrZruu5AZi2B58mmqHt1f4fUFi\n" +
            "brQVpnIIvsEEgSFsiKZFggLwQJ0IRcS9cOsvoEWonO832Aly5PgKuZ9yElRLZjgq\n" +
            "FG9jHPbN5qYbX7X+jNVwxbll2yzfqixuVPuxnDpxkzV2m8PrcQbW8wu3jQIDAQAB\n" +
            "AoGAPFfgFCR/+Ln8HdcvRS05I9US4LoeUFuX+EdibcfC0K1/elM8rdyK6Llpn7T5\n" +
            "romB6YY083T5bgGEjv5sb8KPxPJkXfV4cF0PhKTdC+6bDbKIpKruUDcUMO+n7hbm\n" +
            "G/O7zWf4cBILKjJyBYRHxXB7d9fV81cnNeJ7u+xz0hWmnW0CQQDVDcjoLRr3rQLE\n" +
            "fdBNYxPFxc3zz5L0dK5PYPuqzfullHn8F1Lhwvb9IZIeqf4hP9e9ufUyl+Nfdttq\n" +
            "SvUpb/JTAkEAzdfNUlLo3IDWO/uT7fuJOxvvCnejGOCoL1nw5eM/kQ7uLDrF2JI3\n" +
            "DCEmSPKLb1oJ2Y7sH+newhPKyvQZfBAynwJBAMG2Bdxr3mAhEyoahoFGOx0Py0EJ\n" +
            "k0DmsfIEaO4U2N/kzsCRaE9SWAUxN8zfnOsYRA0B/dmhVh9fTwIm4x9o5HcCQAUH\n" +
            "TZPCRMAGQbWLasy4hVy1TPyjeY+FBXbKqrDjAU2I4NahxO2KfN/F+4pyqmdY+r6e\n" +
            "2DPbYb65/w1AM1Mtjh8CQQDH/yx/IMDn56dZF5Z8vm4rikhjF7UrxunaE7Rt9bK4\n" +
            "Cjn/lBAZSaq//3lv9wtQmEFoWZI9B8IHZnMa019/L9uI";

    //商户入驻
    public ResultModle addMerchant(){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsAddMerchant();
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.submerchant.create.with.auth");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    //查询商户
    public ResultModle queryMerchant(){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsQueryMerchant();
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.submerchant.query");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    //商户绑卡
    public ResultModle bindBankCard(){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsBindBankCard();
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.submerchant.bank.bind");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 支付宝统一收单交易支付(刷卡)
     *
     * @param outTradeNo
     * @param authCode
     * @param totalAmount
     * @return
     */
    public ResultModle tradePay(String outTradeNo,
                                String authCode,
                                String totalAmount){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsTradePay(outTradeNo,authCode,totalAmount);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.submerchant.alipay.trade.pay");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    //支付宝统一收单交易支付(刷卡)
    public ResultModle tradePrecreate(String outTradeNo,

                                      String totalAmount){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsTradePrecreate(outTradeNo,totalAmount);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.submerchant.alipay.trade.precreate");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 订单查询
     *
     * @param outTradeNo
     * @param tradeNo
     * @return
     */
    public ResultModle orderQuery(String outTradeNo,String tradeNo){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsOrderQuery(outTradeNo,tradeNo);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.alipay.trade.query");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 对账单下载
     *
     * @param billDate
     * @param payPlatform
     * @param fileType
     * @return
     */
    public ResultModle downloadBill(String billDate,Integer payPlatform,Integer fileType){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsDownloadBill(billDate, payPlatform, fileType);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.finance.downloadbill");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 订单撤销      刷卡支付用
     *
     * @param outTradeNo
     * @param tradeNo
     * @return
     */
    public ResultModle orderReverse(String outTradeNo,String tradeNo){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsOrderReverse(outTradeNo,tradeNo);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.order.reverse");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 订单关闭接口      未支付的订单使用
     *
     * @param outTradeNo
     * @param tradeNo
     * @return
     */
    public ResultModle orderClose(String outTradeNo, String tradeNo){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsOrderClose(outTradeNo,tradeNo);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.order.close");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 退款
     *
     * @param outTradeNo
     * @param tradeNo
     * @param outRefundNo
     * @return
     */
    public ResultModle refund(String outTradeNo, String tradeNo,String outRefundNo){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsRefund(outTradeNo,tradeNo,outRefundNo);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.pay.refund");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 支付宝H5支付
     *
     * @param outTradeNo
     * @param totalAmount
     * @param buyerLogonId
     * @return
     */
    public ResultModle H5(String outTradeNo, String totalAmount,String buyerLogonId){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsH5(outTradeNo,totalAmount,buyerLogonId);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.submerchant.alipay.trade.create");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 退款查询
     *
     * @param outTradeNo
     * @param tradeNo
     * @param outRefundNo
     * @param refundNo
     * @return
     */
    public ResultModle refundQuery(String outTradeNo, String tradeNo,String outRefundNo,String refundNo){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsRefundQuery(outTradeNo,tradeNo,outRefundNo,refundNo);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.pay.refund.query");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 京东支付
     *
     * @param outTradeNo
     * @param totalFee
     * @return
     */
    public ResultModle jdPay(String outTradeNo,String totalFee){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsJdPay(outTradeNo,totalFee);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.pay.refund.query");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    /**
     * 翼支付
     *
     * @param outTradeNo
     * @param totalFee
     * @return
     */
    public ResultModle bestPay(String outTradeNo,String totalFee){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsBestPay(outTradeNo,totalFee);
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.pay.refund.query");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }

    public ResultModle wxAddMerchant(){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsWxAddMerchant();
        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.wx.submerchant.create");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        addSign(data);

        //发送请求
        return sendPost(data);
    }


    public void addSign(Map<String, String> data){
        //加签
        try {
            String sign = AlipaySignature.rsaSign(data, privateKey, "utf-8");
            data.put("sign",sign);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    public ResultModle sendPost(Map<String, String> data){
        try {
            String post = HttpUtil.post(url, null, data);
            ResultModle resultModle = JSON.parseObject(post, ResultModle.class);

            return resultModle;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultModle.serverError();
    }



    public Map<String,Object> assemblyParamsAddMerchant(){

        Map<String, Object> content = Maps.newHashMap();
        content.put("external_id","XKH06230429150190000");
        content.put("name","xukh测试商户");
        content.put("alias_name","xukh商户");
        content.put("service_phone","18768154773");
        content.put("category_id","2015090800051000");
        content.put("id_card_name","徐楷洪");
        content.put("id_card_num","441581199210274296");
        content.put("store_address","江西省九江市庐山区恩济山庄永安东里2号楼5层永吉鑫宾馆8201室");
        content.put("id_card_hand_img_url","http://file-lp.51fubei.com/liquidator/img/20160929141431277IdCardHand20170330142252.gif");
        content.put("store_front_img_url","http://file-lp.51fubei.com/liquidator/img/20160929141431277StoreFront20170330142253.gif");
        content.put("province","浙江省");
        content.put("city","杭州市");
        content.put("district","余杭区");
        content.put("card_no","6227002********6789");
        content.put("contact_type","LEGAL_PERSON");
        content.put("business_license","510107601109052");
        content.put("business_license_type","NATIONAL_LEGAL");
        content.put("contact_email","12345@qq.com");
        content.put("contact_name","楷洪");

        return content;
    }

    public Map<String,Object> assemblyParamsQueryMerchant(){
        Map<String, Object> content = Maps.newHashMap();
        content.put("sub_merchant_id","20170728101532026951");
        content.put("external_id","XKH06230429150190000");

        return content;
    }

    public Map<String,Object> assemblyParamsBindBankCard(){
        Map<String, Object> content = Maps.newHashMap();
        content.put("sub_merchant_id","20170728101532026951");
        content.put("bank_card_no","6212261810003977296");
        //content.put("bank_card_no","");
        content.put("card_holder","徐楷洪");
        //content.put("isPublicAccount","0");
        //content.put("openBank","XKH06230429150190000");


        return content;
    }

    public Map<String,Object> assemblyParamsTradePay(String outTradeNo,
                                                     String authCode,
                                                     String totalAmount){

        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //服务商单号
        content.put("notify_url","http://xukh.ngrok.cc/callback/alipay"); //支付成功后回调地址
        //content.put("scene","bar_code");                    //支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code	bar_code,wave_code
        content.put("auth_code",authCode);    //支付授权码	28763443825664394
        content.put("total_amount",totalAmount);                 //订单总金额，单位为元，精确到小数点后两位
        //content.put("discountable_amount","20170728101532026951");//参与优惠计算的金额，单位为元
        //content.put("undiscountable_amount","20170728101532026951");//不参与优惠计算的金额，单位为元
        content.put("subject","刷卡支付测试");                  //订单标题	Iphone6 16G
        content.put("body","刷卡订单描述测试");        //订单描述	Iphone6 16G
        SubMerchant subMerchant = new SubMerchant();
        subMerchant.setMerchant_id("20170728101532026951"); //移动支付平台为商户分配的惟一 ID
        content.put("sub_merchant",subMerchant);


        return content;
    }

    public Map<String,Object> assemblyParamsTradePrecreate(String outTradeNo,
                                                           String totalAmount){

        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //服务商单号
        content.put("notify_url","http://23.105.208.8:8089/test"); //支付成功后回调地址
        //content.put("scene","bar_code");                    //支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code	bar_code,wave_code
        content.put("total_amount",totalAmount);                 //订单总金额，单位为元，精确到小数点后两位
        //content.put("discountable_amount","20170728101532026951");//参与优惠计算的金额，单位为元
        //content.put("undiscountable_amount","20170728101532026951");//不参与优惠计算的金额，单位为元
        content.put("subject","扫码支付测试");                  //订单标题	Iphone6 16G
        content.put("body","扫码订单描述测试");        //订单描述	Iphone6 16G
        SubMerchant subMerchant = new SubMerchant();
        subMerchant.setMerchant_id("20170728101532026951"); //移动支付平台为商户分配的惟一 ID
        content.put("sub_merchant",subMerchant);


        return content;
    }


    public Map<String, Object> assemblyParamsOrderQuery(String outTradeNo,String tradeNo){
        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //liquidatorOrderSn
        content.put("trade_no",tradeNo);     //orderSn

        return content;
    }

    public Map<String, Object> assemblyParamsDownloadBill(String billDate,Integer payPlatform,Integer fileType){
        Map<String, Object> content = Maps.newHashMap();
        content.put("bill_date",billDate);
        content.put("pay_platform",payPlatform);
        content.put("file_type",fileType);

        return content;
    }

    public Map<String, Object> assemblyParamsOrderReverse(String outTradeNo,String tradeNo){
        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //liquidatorOrderSn
        content.put("trade_no",tradeNo);     //orderSn

        return content;
    }

    public Map<String, Object> assemblyParamsOrderClose(String outTradeNo,String tradeNo){
        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //liquidatorOrderSn
        content.put("trade_no",tradeNo);     //orderSn

        return content;
    }

    public Map<String, Object> assemblyParamsRefund(String outTradeNo,String tradeNo,String outRefundNo){
        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //liquidatorOrderSn
        content.put("trade_no",tradeNo);     //orderSn
        content.put("out_refund_no",outRefundNo);

        return content;
    }

    public Map<String,Object> assemblyParamsH5(String outTradeNo,
                                               String totalAmount,
                                               String buyerLogonId){

        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //服务商单号
        //content.put("notify_url","http://23.105.208.8:8089/test"); //支付成功后回调地址
        //content.put("scene","bar_code");                    //支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code	bar_code,wave_code
        content.put("total_amount",totalAmount);                 //订单总金额，单位为元，精确到小数点后两位
        //content.put("discountable_amount","20170728101532026951");//参与优惠计算的金额，单位为元
        //content.put("undiscountable_amount","20170728101532026951");//不参与优惠计算的金额，单位为元
        content.put("subject","H5支付测试");                  //订单标题	Iphone6 16G
        content.put("body","H5订单描述测试");        //订单描述	Iphone6 16G
        SubMerchant subMerchant = new SubMerchant();
        subMerchant.setMerchant_id("20170728101532026951"); //移动支付平台为商户分配的惟一 ID
        content.put("sub_merchant",subMerchant);

        //buyer_logon_id  buyer_id
        content.put("buyer_logon_id",buyerLogonId);

        //content.put("buyer_id",subMerchant);


        return content;
    }

    public Map<String, Object> assemblyParamsRefundQuery(String outTradeNo,String tradeNo,String outRefundNo,String refundNo){
        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //liquidatorOrderSn
        content.put("trade_no",tradeNo);     //orderSn
        content.put("out_refund_no",outRefundNo);
        content.put("refund_no",refundNo);

        return content;
    }

    public Map<String, Object> assemblyParamsJdPay(String outTradeNo,String totalFee){
        Map<String, Object> content = Maps.newHashMap();
        content.put("out_trade_no",outTradeNo);     //liquidatorOrderSn
        content.put("order_type","1");
        content.put("total_fee",totalFee);
        content.put("sub_merchant_id","20170728101532026951");
        content.put("body","京东支付测试");

        return content;
    }

    public Map<String, Object> assemblyParamsBestPay(String outTradeNo,String totalFee){
        Map<String, Object> content = Maps.newHashMap();
        content.put("sub_merchant_id","20170728101532026951");
        content.put("out_trade_no",outTradeNo);
        content.put("total_fee",totalFee);
        content.put("body","京东支付测试");

        return content;
    }

    public Map<String, Object> assemblyParamsWxAddMerchant(){
        Map<String, Object> content = Maps.newHashMap();
        content.put("business","203");
        content.put("channel_id","30349322");
        content.put("merchant_name","xukh微信测试商户");
        content.put("merchant_remark","xukh微信测试商户");
        content.put("merchant_shortname","xukh微信测试商户");
        content.put("service_phone","18788888888");
        content.put("contact","徐楷洪");
        content.put("contact_phone","18766666666");

        return content;
    }









    //向清算平台发送请求
    public static void main(String[] args) {
        String url = "https://openapi-liquidation-test.51fubei.com/gateway"; //请求地址
        String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAtLmUANBqioCSvB81\n" +
                "EsHlClyjTc+P9m09Lvbt/HALp3tJMb4BzLTFu7OT95yXVV0/VeUpG3tTlZYrAR+X\n" +
                "fOwIqwIDAQABAkAcdVypBCjCxpxUo1VoLsAycYQFrLmuxGTuEFRJfBtZs/yDRZ45\n" +
                "XRqlQ+LJ1zcS72rVkKmoTb5x/H/m9aPiyCEBAiEA2dmnF3Z9/06EWpo9o1h5pKqw\n" +
                "Z9lJfcBEZA3hBePQsjMCIQDUX5Pmyjl0NaeugaMycjXRUTi+QgLVcW0dyQkdfp0H\n" +
                "qQIhAM+wQSyNOvH72RLHmZvw7Yefcy6OaRIKCymYUb9bwcshAiEAgW+LTiM8ZyZ4\n" +
                "f3RFie5v/JY7NkI3Re2uqnOnmZFclZkCIBjtqrGhIVuBdsnNqKJTJ+H/lGCj8VKw\n" +
                "7EPWRNREMaIX";

        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = Maps.newHashMap();
        content.put("external_id","XKH06230429150135691");
        content.put("name","xukh测试商户");
        content.put("alias_name","xukh商户");
        content.put("service_phone","18201593401");
        content.put("category_id","2015090800051000");
        content.put("id_card_name","徐楷洪");
        content.put("id_card_num","441581199210274296");
        content.put("store_address","江西省九江市庐山区恩济山庄永安东里2号楼5层永吉鑫宾馆8201室");
        content.put("id_card_hand_img_url","http://file-lp.51fubei.com/liquidator/img/20160929141431277IdCardHand20170330142252.gif");
        content.put("store_front_img_url","http://file-lp.51fubei.com/liquidator/img/20160929141431277StoreFront20170330142253.gif");
        content.put("province","浙江省");
        content.put("city","杭州市");
        content.put("district","余杭区");
        content.put("card_no","6227002********6789");
        content.put("contact_type","LEGAL_PERSON");
        content.put("business_license","12343242");
        content.put("business_license_type","NATIONAL_LEGAL");
        content.put("contact_email","12345@qq.com");
        content.put("contact_name","楷洪");

        data.put("app_id","20170630091233203");
        data.put("method","fshows.liquidation.submerchant.create.with.auth");
        data.put("version","1.0");
        data.put("content", JSON.toJSONString(content));

        //加签
        try {
            String sign = AlipaySignature.rsaSign(data, privateKey, "utf-8");
            data.put("sign",sign);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        try {
            String post = HttpUtil.post(url, null, data);
            ResultModle resultModle = JSON.parseObject(post, ResultModle.class);
            if (resultModle.isSuccess()) {
                Map returnValue = (Map) resultModle.getReturnValue();
                System.out.println(returnValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
