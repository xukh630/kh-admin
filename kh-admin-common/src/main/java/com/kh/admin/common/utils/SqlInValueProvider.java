package com.kh.admin.common.utils;
/**
 *
 * Created by qiuzhen on 16/3/24.
 */
public interface SqlInValueProvider<T> {

    /**
     * sql in语句的value值获取
     * @param t 业务对象
     * @return 要放在in里面的值
     */
    Object getInValue(T t);
}



