package com.kh.admin.api.controller;

import com.kh.admin.service.ThreadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 所在的包名: com.kh.admin.api.controller
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 20:21 2017/8/3
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Resource
    private ThreadService threadService;

    @RequestMapping("/test")
    public void go(){

    }
}
