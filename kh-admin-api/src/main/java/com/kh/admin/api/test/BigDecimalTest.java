package com.kh.admin.api.test;

import com.kh.admin.common.utils.BigDecimalUtil;
import com.kh.admin.common.utils.DateUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 所在的包名: com.kh.admin.api.test
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 11:54 2017/8/8
 */
public class BigDecimalTest {
    /*public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal bigDecimal = BigDecimalUtil.valueOf(2);
        System.out.println(zero + "    " + bigDecimal);
    }*/

    public static void main(String[] args) {
        Date time = Calendar.getInstance().getTime();
        System.out.println(time);
    }
}
