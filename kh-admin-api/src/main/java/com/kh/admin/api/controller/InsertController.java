package com.kh.admin.api.controller;

import com.kh.admin.service.InsertService;
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

    @RequestMapping("/test")
    public void test(){
        insertService.insert();
    }

}
