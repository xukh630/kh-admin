package com.kh.admin.api.controller;/**
 * Created by Administrator on 2017/7/25.
 */

import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xukh
 * @create 2017-07-25-16:52
 */
@RestController
@RequestMapping("/test")
public class testController {
    public static void main(String[] args) {
        Integer day = Integer.valueOf(DateTime.now().plusDays(-1).toString("yyyyMMdd"));
        System.out.println(day);

        DateTime now = DateTime.now();
        System.out.println(now);

        DateTime dateTime = new DateTime("2017-07-01T16:54:18.297+08:00");
        String yyyyMMdd = dateTime.plusDays(-1).toString("yyyyMMdd");
        System.out.println(yyyyMMdd);
    }

}
