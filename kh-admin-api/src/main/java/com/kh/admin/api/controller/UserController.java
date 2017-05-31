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
    public void test(){
        System.out.println("hehe");
    }
}
