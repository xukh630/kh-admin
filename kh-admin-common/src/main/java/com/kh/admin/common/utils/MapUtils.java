package com.kh.admin.common.utils;

import com.google.common.collect.Maps;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by qiuzhen on 16/3/27.
 */
public class MapUtils {

    /**
     * 将一个迭代器转换为一个map
     * <p>
     * value就是迭代器的自身元素
     * <p>
     * key由mapKeyProvidor指定
     *
     * @param iterator       迭代器
     * @param mapKeyProvidor map的key的提供者
     * @return
     */
    public static <K, V> Map<K, V> getMap(Iterator<V> iterator, MapKeyProvidor<K, V> mapKeyProvidor) {
        Map<K, V> map = new HashMap<K, V>();
        while (iterator.hasNext()) {
            V v = iterator.next();
            map.put(mapKeyProvidor.getKey(v), v);
        }
        return map;
    }

    /**
     * JavaBean对象转化成Map对象
     *
     * @param javaBean
     * @return
     * @author jqlin
     */
    public static Map<String, Object> java2Map(Object javaBean) {
        Map<String, Object> map = Maps.newLinkedHashMap();

        try {
            // 获取javaBean属性
            BeanInfo beanInfo = Introspector.getBeanInfo(javaBean.getClass());

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (propertyDescriptors != null && propertyDescriptors.length > 0) {
                String propertyName = null; // javaBean属性名
                Object propertyValue = null; // javaBean属性值
                for (PropertyDescriptor pd : propertyDescriptors) {
                    propertyName = pd.getName();
                    if (!propertyName.equals("class")) {
                        Method readMethod = pd.getReadMethod();
                        propertyValue = readMethod.invoke(javaBean, new Object[0]);
                        map.put(propertyName, propertyValue);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


}


