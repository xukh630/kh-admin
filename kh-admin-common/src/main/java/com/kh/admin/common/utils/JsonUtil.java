package com.kh.admin.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类JsonUtil.java的实现描述：TODO 类实现描述 
 * @author zhh 2015年4月21日 下午9:01:20
 */
public class JsonUtil {

    /**
     * 把对象转换为json文本
     * @param object
     * @return
     */
    public static String toJsonString(Object object){
        SerializerFeature[] sf = {SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteMapNullValue};
        String text = JSON.toJSONString(object, sf);
        return text;
//        JSONObject json = new JSONObject( object );    
//        return json.toString();
    }
    
    /**
     * 把json文本转换为指定对象
     * @param jsonText
     * @param clazz
     * @return
     */
    public static Object toObject(String jsonText, Class clazz){
        Object obj = JSON.parseObject(jsonText, clazz);
        return obj;
    }
    
    /**
     * 把json文本转换为Map
     * @return
     */
    public static Map toMap(String text){
        return JSON.parseObject(text, Map.class);
    }
    
    public static JSONObject toJsonObject(String text){
        return (JSONObject) JSON.parse(text);
    }

    /**
     * 把下划线的json转成驼峰命名的对象
     * @param humpJsonStr
     * @param classType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static  <T> T jsonHumpToObj(String humpJsonStr, Class<T> classType) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        return mapper.readValue(humpJsonStr, classType);
    }

    /**
     * 把对象转换为json文本 jackson
     * @param object
     * @return
     */
    public static String toJSonByJackson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(object);
    }

    /**
     * 把驼峰命名的对象转换为下划线的json文本 jackson
     * @param object
     * @return
     */
    public static String toUnderlineJSonByJackson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        return mapper.writeValueAsString(object);
    }

    /**
     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
     * (1)转换为普通JavaBean：readValue(json,Student.class)
     * (2)转换为List,如List<Student>,将第二个参数传递为Student
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
     *
     * @param jsonStr
     * @param valueType
     * @return
     */
    public static <T> T getObjectFromJson(String jsonStr, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonStr, valueType);
    }

    public static <T> T getObjectFromJson(String jsonStr, TypeReference<T> valueTypeRef) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonStr, valueTypeRef);
    }

    public static Map toHashMap(String text){
        return JSON.parseObject(text, LinkedHashMap.class);
    }


    //风控接口返回值
//   {
//        "alipay_security_data_info_securitydata_query_response":{
//        "code":"10000",
//         "msg":"Success",
//         "result":"{ \"210100197210019087\": \"hasRisk\" , \"130130197001303316\":\"noRisk\"}"
//            },
//        "sign":"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE"
//    }

       /* [
            {"external_id":"new_id_00","cert_no":"6530*****120021","company_name":"浙江*****有限公司","business_license_no":"44******2153","bank_card_no":"696*****4796"},
        {"external_id":"new_id_01","cert_no":"65*****99610022","company_name":"浙江*****有限公司","business_license_no":"44078***12154","bank_card_no":"696******791"}
        ]*/

       //[{"external_id":"111111111","company_name":"noRisk","cert_no":"noRisk","business_license_no":"noRisk","bank_card_no":"noRisk"}]
}
