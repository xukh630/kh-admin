package com.kh.admin.service;

import com.kh.admin.model.form.TestForm;
import org.springframework.stereotype.Service;
import org.testng.collections.Lists;

import java.util.List;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 11:58 2017/8/7
 */
@Service
public class testService  {

    public static void main(String[] args) {
        List<Object> list = Lists.newArrayList();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<Object> lists = Lists.newArrayList();
        lists.add("q");
        lists.add("w");
        lists.add("e");
        lists.add("r");

        list.addAll(lists);

        for (int i = 0; i < list.size();i ++) {
            System.out.println(list.get(i));
        }

        System.out.println("-----------------------------");

        for (int i = 0; i < lists.size();i ++) {
            System.out.println(lists.get(i));
        }



    }

}
