package com.kh.admin.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目：liquidator-admin
 * 包名：com.fshows.liquidator.admin.api.controller
 * 功能：
 * 时间：2017-01-10
 * 作者：呱牛
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test")
    public String test(String a ,
                     String b){
        if ( a == null && b != null || a != null && b == null){
            return "false";
        }
        return "success";
    }

    public static void main(String[] args) {
        String address = "浙江省杭州市余杭区大明湖畔省";
        String adds = "北京北京市海淀区恩济山庄永安东里2号楼5层永吉鑫宾馆8201室";

        int a = address.indexOf("省");
        int b = address.indexOf("市");
        int c = address.indexOf("区");

        System.out.println(a + "  " + b + "  " + c);

        String province = address.substring(0,a + 1);
        String city = address.substring(a + 1, b + 1);
        String ss = address.substring(b + 1, c + 1);
        System.out.println(province + " "+ city+" "+ss);

        int d = 2;
        int e = adds.indexOf("市");
        int f = adds.indexOf("区");
        String aprovince = adds.substring(0,d );
        String acity = adds.substring(d , e + 1);
        String ass = adds.substring(e + 1, f + 1);
        System.out.println(aprovince + " "+ acity+" "+ass);
    }

}
