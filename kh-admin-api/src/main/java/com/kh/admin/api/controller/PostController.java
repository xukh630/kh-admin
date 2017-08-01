package com.kh.admin.api.controller;/**
 * Created by Administrator on 2017/7/28.
 */

import com.kh.admin.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xukh
 * @create 2017-07-28-11:14
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    @RequestMapping("/addMerchant")
    public void addMerchant(){
        postService.add();
    }


}
