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
        postService.addMerchant();
    }

    @RequestMapping("/queryMerchant")
    public void queryMerchant(){
        postService.queryMerchant();
    }

    @RequestMapping("/bindBankCard")
    public void bindBankCard(){
        postService.bindBankCard();
    }

    /**
     * 必须在authCode 没有改变之前完成刷卡   否则pay_platform_order_sn 为空 无法完成支付
     * @param outTradeNo
     * @param authCode
     */
    @RequestMapping("/tradePay")
    public void tradePay(String outTradeNo,
                         String authCode){
        postService.tradePay(outTradeNo,authCode);
    }

    @RequestMapping("/orderQuery")
    public void orderQuery(){
        postService.orderQuery();
    }

}
