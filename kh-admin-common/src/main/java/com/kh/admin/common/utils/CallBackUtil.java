package com.kh.admin.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by caofangyi on 2017/5/12.
 */
public class CallBackUtil {

    /**
     * 根据输入量里面获取内容
     * @param bufferedReader
     * @return
     * @throws IOException
     */
     public static String getCallBackContent(BufferedReader bufferedReader) throws IOException {
         StringBuffer contentBuffer = new StringBuffer();
         String line = null;
         while (!StringUtils.isBlank((line = bufferedReader.readLine()))) {
             contentBuffer.append(line);
         }
         return  contentBuffer.toString();
     }

     public static String getBankType(String type){
          if("1".equals(type)){
              return "DEBIT";  //1:借记卡
          }else if("2".equals(type)){
              return "CREDIT"; //2-信用卡
          }else {
              return type;
          }
     }
     
     public static void main(String[] args){
            Long a = 109L;
            System.out.println(BigDecimalUtil.points2Yuan(a.intValue()));
            String timeStr="20170516214041";
          //  return formatDate(date, "yyyy-MM-dd HH:mm:ss");

         System.out.println(DateUtil.formatDateTime(DateUtil.toDate(timeStr, "yyyyMMddHHmmss")));
            
     }

    /**
     * 保持跟老接口一致的状态  京东2：表示支付成功的状态
     * 交易状态：  0 或者 1     0代表支付成功      1代表支付失败
     * @param status
     * @return
     */
    public static String convertJdStatus(Integer status) {
        if("2".equals(status.toString())){
            return "0";
        }else {
            return  "1";
        }
    }
}
