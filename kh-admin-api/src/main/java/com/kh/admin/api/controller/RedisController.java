package com.kh.admin.api.controller;/**
 * Created by Administrator on 2017/7/19.
 */

import com.kh.admin.common.utils.ResourceUtil;
import com.kh.admin.service.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @author xukh
 * @create 2017-07-19-20:34
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    @RequestMapping("/add")
    public void add(){
        redisService.redisConnect1();
        //redisService.testMap();
        //redisService.test();
        //redisService.close();
        //redisService.removeAll();
        //redisService.listTest();
        //redisService.setTest();
        //redisService.setDiff();
        //redisService.live();
        redisService.liv();
    }

    @RequestMapping("/test")
    public void test(){

    }

}
