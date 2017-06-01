package com.kh.admin.common.utils;

import java.util.*;

/**
 * sql工具
 * Created by qiuzhen on 16/3/24.
 */
public class SqlUtils {

    /**
     * 将list中的特定字段封装起来
     * 每1000个值放在一个set中(oracle in语句的值不能超过1000个)
     *
     * @param tIterator               通用业集合迭代器
     * @param sqlInValueProvider in的值获取接口
     * @return
     */
    public <T> List<Set> getSqlInList(Iterator<T> tIterator, SqlInValueProvider<T> sqlInValueProvider) {
        List<Set> setList = new ArrayList<Set>();

        int i = 0;
        Set set = new HashSet();
        while (tIterator.hasNext()) {
            if (i % 1000 == 0) {
                set = new HashSet();
                setList.add(set);
            }
            T t = tIterator.next();
            set.add(sqlInValueProvider.getInValue(t));
            i++;
        }
        return setList;
    }


}


