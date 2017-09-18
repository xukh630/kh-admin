package com.kh.admin.api.controller;

import com.kh.admin.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 所在的包名: com.kh.admin.api.controller
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 20:37 2017/9/3
 */
@RestController
@RequestMapping("/insert")
public class InsertController {

    @Resource
    private InsertService insertService;
    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public void test(){
        //testService.insert();
        insertService.insert();
    }

    @RequestMapping("/user")
    public void test(String username ,
                     String password,
                     String salt,
                     Integer status){
        insertService.insertUser(username, password, salt, status);
    }

    public static void main(String[] args) {
        String s = "/20170918/shop_pic/indoor/20161025115747161/5bd6b1a8717d48e3b6b71fbb4fe725de/shop_indoor.jpg|/20170918/shop_pic/indoor/20161025115747161/5bd6b1a8717d48e3b6b71fbb4fe725de/shop_indoor.jpg|/20170918/shop_pic/indoor/20161025115747161/5bd6b1a8717d48e3b6b71fbb4fe725de/shop_indoor.jpg|/20170918/shop_pic/indoor/20161025115747161/5bd6b1a8717d48e3b6b71fbb4fe725de/shop_indoor.jpg";
        String a = "1|2|3|4|5|6|7|8";
        String d = "11111,222222,333333";
        String q = "aaa";
        String w = "bbb";
        String e = "ccc";
        String r = "ddd";

        String[] split = s.split("\\|");
        String[] split1 = a.split("\\|");
        String[] split2 = d.split(",");
        System.out.println(split.length);
        System.out.println(split1.length);
        System.out.println(split2.length);

        System.out.println(q+"|" + w+ "|"+e +"|"+r);


    }

}
