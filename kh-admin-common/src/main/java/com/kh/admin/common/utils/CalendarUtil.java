package com.kh.admin.common.utils;/**
 * Created by Administrator on 2017/7/17.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xukh
 * @create 2017-07-17-22:09
 */
public class CalendarUtil {

    private static Map<String, String> getDate(String date1) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(date1);

        Calendar calendar1 = Calendar.getInstance();  // 使用默认时区和语言环境获得一个日历。
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();

        calendar1.setTime(date);  //setTime(Date date) 使用给定的Date设置此Calendar的时间。
        calendar2.setTime(date);
        calendar3.setTime(date);

        calendar1.add(Calendar.MONTH, -1);    //上A
        Date Date1 = calendar1.getTime();

        calendar2.add(Calendar.MONTH, 0);     //<span style="font-family: Arial, Helvetica, sans-serif;">中C</span>

        Date Date2 = calendar2.getTime();

        calendar3.add(Calendar.MONTH, 1);     //<span style="font-family: Arial, Helvetica, sans-serif;">下B</span>

        Date Date3 = calendar3.getTime();


        /**
         * 上月第1天
         */
        //GregorianCalendar 是 Calendar 的一个具体子类
        GregorianCalendar gc1 = (GregorianCalendar) Calendar.getInstance();
        gc1.setTime(Date1);
        gc1.set(Calendar.DAY_OF_MONTH, 1);      //设置该月的第一天
        String a_day_first = df.format(gc1.getTime());
        StringBuffer str_a = new StringBuffer().append(a_day_first).append(" 00:00:00");    //拼接 时分秒
        a_day_first = str_a.toString();
        System.out.println("上月的第一天\t"+a_day_first);

        /**
         * 上月最后一天
         */
        calendar1.add(Calendar.MONTH, 1);        //加一个月
        calendar1.set(Calendar.DATE, 1);         //设置为该月第一天
        calendar1.add(Calendar.DATE, -1);        //再减一天即为上个月最后一天
        String a_day_last = df.format(calendar1.getTime());
        StringBuffer endStra = new StringBuffer().append(a_day_last).append(" 23:59:59");//拼接 时分秒
        a_day_last = endStra.toString();
        System.out.println("上月最后一天\t"+a_day_last);

        /**
         * 本月第一天
         */
        GregorianCalendar gc2 = (GregorianCalendar) Calendar.getInstance();
        gc2.setTime(Date2);
        gc2.set(Calendar.DAY_OF_MONTH, 1);          //设置该月的第一天
        String b_day_first = df.format(gc2.getTime());
        StringBuffer str_b = new StringBuffer().append(b_day_first).append(" 00:00:00");//拼接 时分秒
        b_day_first = str_b.toString();
        System.out.println("本月的第一天\t"+b_day_first);

        /**
         * 本月最后一天
         */
        calendar2.add(Calendar.MONTH, 1);        //加一个月
        calendar2.set(Calendar.DATE, 1);         //设置为该月第一天
        calendar2.add(Calendar.DATE, -1);        //再减一天即为上个月最后一天
        String b_day_last= df.format(calendar2.getTime());
        StringBuffer endStrb = new StringBuffer().append(b_day_last).append(" 23:59:59");   //拼接 时分秒
        b_day_last = endStrb.toString();
        System.out.println("本月最后一天\t"+b_day_last);

        /**
         * 下月第1天
         */
        GregorianCalendar gc3 = (GregorianCalendar) Calendar.getInstance();
        gc3.setTime(Date3);
        gc3.set(Calendar.DAY_OF_MONTH, 1);
        String c_day_first = df.format(gc3.getTime());
        StringBuffer str_c = new StringBuffer().append(c_day_first).append(" 00:00:00");//拼接 时分秒
        c_day_first = str_c.toString();
        System.out.println("下月的第一天\t"+c_day_first);

        /**
         * 下月最后1天
         */
        calendar3.add(Calendar.MONTH, 1);        //加一个月
        calendar3.set(Calendar.DATE, 1);         //设置为该月第一天
        calendar3.add(Calendar.DATE, -1);        //再减一天即为上个月最后一天
        String c_day_last= df.format(calendar3.getTime());
        StringBuffer endStrc = new StringBuffer().append(c_day_last).append(" 23:59:59"); //拼接 时分秒
        c_day_last = endStrc.toString();
        System.out.println("下月最后一天\t"+c_day_last);

        Map<String, String> map = new HashMap<String, String>();

        map.put("a_day_first", a_day_first);
        map.put("a_day_last", a_day_last);

        map.put("b_day_first", b_day_first);
        map.put("b_day_last", b_day_last);


        map.put("c_day_first", c_day_first);
        map.put("c_day_last", c_day_last);
        return map;
    }

    /** * 获得指定日期的前一天 *
     @param specifiedDay
      * @return
     * @throws Exception */
    public static String getSpecifiedDayBefore(String specifiedDay){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date); int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-1);
        String dayBefore=new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        return dayBefore;
    }
    /**
     * 获得指定日期的后一天
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+1);
        String dayAfter=new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        return dayAfter;
    }
}
