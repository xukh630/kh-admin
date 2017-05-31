package com.kh.admin.common.constants;

/**
 * Created by Administrator on 2017/2/17.
 */
public class ConstantsUtils {

   public static String getPayStatus(Integer payStatus){

       if (payStatus == 1){

           return "支付成功";
       } else if (payStatus == 2) {

           return "支付失败";
       } else if (payStatus == 3) {

           return "退款中";
       } else if (payStatus == 4) {

           return "退款成功";
       } else if (payStatus == 5) {

           return "退款失败";
       } else {

           return "未支付";
       }
   }
}
