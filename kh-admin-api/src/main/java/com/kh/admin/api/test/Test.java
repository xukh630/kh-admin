package com.kh.admin.api.test;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kh.admin.common.utils.*;
import com.kh.admin.model.form.UserForm;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/2/15.
 */
public class Test {

    /*public static void main(String[] args) throws IOException {
        String content ="{\"username\":\"胖头欧巴\",\"password\":\"123\",\"app_id\":\"11111\"}";
        UserForm form = new UserForm();
        form.setAppId("111");
        form.setUsername("hehe");
        form.setPassword("123");
        String s = JSON.toJSONString(form);
        String s1 = JsonUtil.toJSonByJackson(form);
        String s2 = JsonUtil.toJsonString(form);
        UserForm userForm = JsonUtil.jsonHumpToObj(content, UserForm.class);
        System.out.println(s + "  " + s1 + "  " + s2);
        System.out.println(userForm.getUsername() + " " + userForm.getPassword() + " " + userForm.getAppId());
    }*/

    /*public static void main(String[] args) {
        String nowDateFormat = DateUtil.getNowDateFormat();
        Date date = DateUtil.toDate(nowDateFormat);
        System.out.println(date);
    }*/

    /*public static void main(String[] args) {
        // 获取当前年份、月份、日期
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        int hour = cale.get(Calendar.HOUR_OF_DAY);
        int minute = cale.get(Calendar.MINUTE);
        int second = cale.get(Calendar.SECOND);
        int dow = cale.get(Calendar.DAY_OF_WEEK);
        int dom = cale.get(Calendar.DAY_OF_MONTH);
        int doy = cale.get(Calendar.DAY_OF_YEAR);

        System.out.println("Current Date: " + cale.getTime());
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);
        System.out.println("Day of Week: " + dow);
        System.out.println("Day of Month: " + dom);
        System.out.println("Day of Year: " + doy);

        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());
        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);

        // 获取当前日期字符串
        Date d = new Date();
        System.out.println("当前日期字符串1：" + format.format(d));
        System.out.println("当前日期字符串2：" + year + "/" + month + "/" + day + " "
                + hour + ":" + minute + ":" + second);
    }*/



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



/*    public static void main(String[] args) throws ParseException {
        String custId = RandomNumberUtil.createCustId();
        String nowDateStr = DateUtil.getNowDateStr();
        System.out.println(nowDateStr);
        System.out.println(custId);  //14

    }*/

    /*public static void main(String[] args) throws ParseException {
        String time = "2017-7-16 10:01:01";

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date parse = date.parse(time);

        long time1 = parse.getTime();

        long now = DateUtil.getNow();

        Long a = 1500134400000l;
        Long b = 1500220800000l;

        Date date1 = new Date();
        date1.setTime(b);

        System.out.println(date);
        System.out.println(parse);
        System.out.println(time1);
        System.out.println(now);
        System.out.println(now - time1);
        System.out.println(b-a);
        System.out.println(date1);



    }*/

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

    /*public static void main(String[] args) {
        String specifiedDayBefore = getSpecifiedDayBefore("20170701");
        System.out.println(specifiedDayBefore);
        String specifiedDayAfter = getSpecifiedDayAfter("20170630");
        System.out.println(specifiedDayAfter);
    }*/

    /*public static void main(String[] args) {
        String system = ResourceUtil.getSystem("qiniu.access.key");
        System.out.println(system);
    }*/

    /*public static void main(String[] args) {
        String bankCard = "    11111  111111 111111 ";
        System.out.println(bankCard);
        bankCard = bankCard.replaceAll(" ", "");
        System.out.println(bankCard);

        String bank= "    11111  111111 111111 ";
        bank = bank.trim();
        System.out.println(bank);
    }*/

    public static void main(String[] args) {
        BigDecimal a = BigDecimal.TEN;
        BigDecimal b = BigDecimal.ONE;
        BigDecimal subtract = BigDecimalUtil.subtract(a, b);
        System.out.println(subtract);
    }
}
