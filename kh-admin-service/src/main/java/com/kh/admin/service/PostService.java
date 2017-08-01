package com.kh.admin.service;/**
 * Created by Administrator on 2017/7/28.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.kh.admin.common.result.ResultModle;
import com.kh.admin.common.utils.HttpUtil;
import okhttp3.*;
import org.apache.http.client.methods.HttpPost;
import org.springframework.stereotype.Service;
import org.testng.collections.Maps;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.Map;

/**
 * @author xukh
 * @create 2017-07-28-9:29
 */
@Service
public class PostService {

    String url = "https://openapi-liquidation-test.51fubei.com/gateway"; //请求地址
    String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAtLmUANBqioCSvB81\n" +
            "EsHlClyjTc+P9m09Lvbt/HALp3tJMb4BzLTFu7OT95yXVV0/VeUpG3tTlZYrAR+X\n" +
            "fOwIqwIDAQABAkAcdVypBCjCxpxUo1VoLsAycYQFrLmuxGTuEFRJfBtZs/yDRZ45\n" +
            "XRqlQ+LJ1zcS72rVkKmoTb5x/H/m9aPiyCEBAiEA2dmnF3Z9/06EWpo9o1h5pKqw\n" +
            "Z9lJfcBEZA3hBePQsjMCIQDUX5Pmyjl0NaeugaMycjXRUTi+QgLVcW0dyQkdfp0H\n" +
            "qQIhAM+wQSyNOvH72RLHmZvw7Yefcy6OaRIKCymYUb9bwcshAiEAgW+LTiM8ZyZ4\n" +
            "f3RFie5v/JY7NkI3Re2uqnOnmZFclZkCIBjtqrGhIVuBdsnNqKJTJ+H/lGCj8VKw\n" +
            "7EPWRNREMaIX";

    public void add(){
        Map<String, String> data = Maps.newHashMap();
        Map<String, Object> content = assemblyParamsAddMerchant();
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

    public Map<String,Object> assemblyParamsAddMerchant(){

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

        /*OkHttpClient okHttpClient = new OkHttpClient();


        FormBody.Builder bodyBuilder = new FormBody.Builder();

        for (String key : data.keySet()) {
            bodyBuilder.add(key,data.get(key));
        }

        RequestBody body = bodyBuilder.build();
        Request request = new Request.Builder().url(url).post(body).build();

        Call call = okHttpClient.newCall(request);

        //异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Boolean result = Boolean.FALSE;
                try {
                    JSONObject responseBody = JSON.parseObject(response.body().toString());
                    System.out.println(responseBody.toString());
                    result = responseBody.getBoolean("success");
                } catch (JSONException e) {
                    System.out.println("解析返回值失败");
                }

                if (result) {
                    System.out.println("这里写逻辑");
                } else {
                    System.out.println("这里再写逻辑");
                }
            }
        });*/
    }


   /*String result =  {"return_value":{"sub_merchant_id":"20170728101532026951",
            "external_id":"XKH06230429150135691",
            "name":"xukh测试商户",
            "alias_name":"xukh商户",
            "service_phone":"18201593401",
            "category_id":"2015063000020189",
            "liquidator_name":"xukh",
            "status":"1"},
            "success":true}*/
}
