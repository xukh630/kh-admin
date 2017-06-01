package com.kh.admin.common.utils;

/**
 * key生成者
 * Created by qiuzhen on 16/3/27.
 */
public interface MapKeyProvidor<K, T> {

    /**
     * 从元素自身取出一个key值
     *
     * @param t
     * @return
     */
    K getKey(T t);
}
