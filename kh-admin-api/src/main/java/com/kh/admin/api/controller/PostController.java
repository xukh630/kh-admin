package com.kh.admin.api.controller;/**
 * Created by Administrator on 2017/7/28.
 */

import com.kh.admin.common.result.ResultModle;
import com.kh.admin.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

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
    public ResultModle addMerchant(){
        return postService.addMerchant();
    }

    @RequestMapping("/queryMerchant")
    public ResultModle queryMerchant(){
        return postService.queryMerchant();
    }

    @RequestMapping("/bindBankCard")
    public ResultModle bindBankCard(){
        return postService.bindBankCard();
    }

    /**
     * 支付宝刷卡支付接口
     *
     * 必须在authCode 没有改变之前完成刷卡   否则pay_platform_order_sn 为空 无法完成支付
     *
     * @param outTradeNo
     * @param authCode
     */
    @RequestMapping("/tradePay")
    public ResultModle tradePay(String outTradeNo,
                                String authCode,
                                String totalAmount){
        return postService.tradePay(outTradeNo,authCode,totalAmount);
    }

    /**
     * 支付宝扫码支付
     *
     * @param outTradeNo
     * @param totalAmount
     * @return
     */
    @RequestMapping("/tradePrecreate")
    public ResultModle tradePrecreate(String outTradeNo,
                                      String totalAmount){
        return postService.tradePrecreate(outTradeNo,totalAmount);
    }

    /**
     * 订单查询             两个参数都存在时,优先取tradeNo
     *
     * @param outTradeNo
     * @param tradeNo
     * @return
     */
    @RequestMapping("/orderQuery")
    public ResultModle orderQuery(@RequestParam(value = "outTradeNo" ,required = false)String outTradeNo,
                                  @RequestParam(value = "tradeNo" ,required = false) String tradeNo){
        return postService.orderQuery(outTradeNo,tradeNo);
    }

    /**
     * 对账单下载
     *
     * @param billDate
     * @param payPlatform       1、支付宝 2、微信  3、京东  4、翼支付
     * @param fileType
     * @return
     */
    @RequestMapping("/downloadBill")
    public ResultModle downloadBill(@RequestParam(required = true) String billDate,
                                    @RequestParam(required = true,defaultValue = "1") Integer payPlatform,
                                    @RequestParam(required = false) Integer fileType){

        return postService.downloadBill(billDate, payPlatform, fileType);
    }

    /**
     * 订单撤销     finance             刷卡支付订单走撤销接口     未支付的订单走关闭接口
     *
     * @param outTradeNo
     * @param tradeNo
     * @return
     */
    @RequestMapping("/orderReverse")
    public ResultModle orderReverse(@RequestParam(value = "outTradeNo" ,required = false)String outTradeNo,
                                    @RequestParam(value = "tradeNo" ,required = false) String tradeNo){

        return postService.orderReverse(outTradeNo,tradeNo);
    }

    /**
     * 订单关闭接口           除刷卡支付可用         未支付的订单可用
     *
     * @param outTradeNo
     * @param tradeNo
     * @return
     */
    @RequestMapping("/orderClose")
    public ResultModle orderClose(@RequestParam(value = "outTradeNo" ,required = false)String outTradeNo,
                                  @RequestParam(value = "tradeNo" ,required = false) String tradeNo){

        return postService.orderClose(outTradeNo,tradeNo);
    }

    /**
     * 退款    扫码支付可用
     *
     * @param outTradeNo
     * @param tradeNo
     * @param outRefundNo
     * @return
     */
    @RequestMapping("/refund")
    public ResultModle refund(@RequestParam(value = "outTradeNo" ,required = false)String outTradeNo,
                              @RequestParam(value = "tradeNo" ,required = false) String tradeNo,
                              @RequestParam(value = "outRefundNo" ,required = false) String outRefundNo){

        outRefundNo = "refund"+outTradeNo;
        System.out.println(outRefundNo);
        return postService.refund(outTradeNo,tradeNo,outRefundNo);
    }

    @RequestMapping("/H5")
    public ResultModle H5(String outTradeNo,
                          String totalAmount,
                          String buyerLogonId){

        return postService.H5(outTradeNo,totalAmount,buyerLogonId);
    }

}
