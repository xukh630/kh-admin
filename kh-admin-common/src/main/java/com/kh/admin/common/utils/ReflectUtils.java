/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.common.utils;


import com.google.common.collect.Maps;
import com.kh.admin.common.result.ResultModle;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 项目：liquidator-platform-openapi
 * 包名：com.fshows.liquidator.platform.openapi.common.utils
 * 功能：
 * 时间：2016-08-10 8:54
 * 作者：Mr.Kiwi
 */
public class ReflectUtils {

    /**
     * @param className 类名
     * @param methodName 方法名
     * @param param     方法参数
     * @param parameterType 方法参数类型
     * @throws Exception
     */
    public static ResultModle callMethod(String className, String methodName, Object[] param, Class...parameterType) throws Exception {
        Class cObj = Class.forName(className);
        Method m = cObj.getDeclaredMethod(methodName,parameterType);
       return (ResultModle) m.invoke(cObj.newInstance(),param);
    }

    /**
     * 获得指定类型的属性map
     * @param source
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> Map<String, Object> getFieldMap(T source) throws IllegalAccessException {

        if (source == null){

            return Maps.newHashMap();
        }

        Field[] orderFields = source.getClass().getDeclaredFields();
        Map<String, Object> sourceMap = Maps.newHashMap();
        for (Field orderField : orderFields) {
            // 设置可访问权限
            orderField.setAccessible(true);
            String fieldName =
                orderField.toString().substring(orderField.toString().lastIndexOf(".") + 1);
            Object value = orderField.get(source);
            sourceMap.put(fieldName, value);
        }

        return sourceMap;
    }

}
