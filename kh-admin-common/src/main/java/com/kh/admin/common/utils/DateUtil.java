package com.kh.admin.common.utils;


import com.github.pagehelper.StringUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 类DateUtil.java的实现描述：TODO 类实现描述
 *
 * @author zhh 2015年4月21日 下午9:00:57
 */
public class DateUtil {

    private final static Logger log = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 日期格式化对象
     */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 日期时间格式化对象
     */
    private static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 把时间戳转换为yyyy-MM-dd HH:mm:ss格式时间字符串
     *
     * @param timestamp
     * @return
     */
    public static String formatDateString(long timestamp) {

        String str = DATE_TIME_FORMAT.format(timestamp);

        return str;
    }



    /**
     * 把字符串转换为日期
     *
     * @param dateStr
     * @return
     */
    public static Date toDate(String dateStr, String dateFormat) {
        String str = dateStr.trim();

        if (StringUtil.isEmpty(dateFormat)) {
            if (str.matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
                dateFormat = "yyyy-MM-dd HH:mm:ss";
            } else if (str.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
                dateFormat = "yyyy-MM-dd";
            }
        }

        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            log.error("format to date err:" + e.getMessage(), e);
        }

        return null;
    }

    public static Date toDate(String dateStr) {
        return toDate(dateStr, null);
    }

    public static Date toDate(long m) {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(m);
        return c1.getTime();
    }

    /**
     * 清除时间
     *
     * @param date
     * @return
     */
    public static void clearTimes(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 精确计算(忽略时间)两个日期相差的天数。 如: 2007-1-5 与 2007-1-6 返回1 2007-1-5 与 2007-1-4 返回-1 2007-1-5 与 2007-1-6 返回0
     *
     * @param startDay 开始日期
     * @param endDay   结束日期
     * @return 相差的天数
     */
    public static int getBetweenDays(Calendar startDay, Calendar endDay) {
        Calendar date1 = (Calendar) startDay.clone();
        Calendar date2 = (Calendar) endDay.clone();

        // 不比较时分秒信息
        clearTimes(date1);
        clearTimes(date2);

        if (date1.equals(date2))
            return 0;

        long m1 = date1.getTimeInMillis();
        long m2 = date2.getTimeInMillis();

        return (int) ((m2 - m1) / 24 / 60 / 60 / 1000);
    }

    /**
     * 精确计算(忽略时间)两个日期相差的天数。 如: 2007-1-5 与 2007-1-6 返回1 2007-1-5 与 2007-1-4 返回-1 2007-1-5 与 2007-1-5 返回0
     *
     * @param startDay 开始日期
     * @param endDay   结束日期
     * @return 相差的天数
     */
    public static int getBetweenDays(Date startDay, Date endDay) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startDay);
        c2.setTime(endDay);
        return getBetweenDays(c1, c2);
    }

    /**
     * Format Date into which format you define
     *
     * @param date(java.util.Date)
     * @return String example formatDate(date, "MMMM dd, yyyy") = July 20, 2000
     */
    public static String formatDate(Date date, String newFormat) {
        if ((date == null) || (newFormat == null)) {
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(newFormat);

        return formatter.format(date);
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 取得剩余时间
     *
     * @param date
     * @return
     */
    public static String getRemainTime(Date date) {
        if (date == null)
            return "";

        StringBuilder sb = new StringBuilder();

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        long m1 = start.getTimeInMillis();
        long m2 = end.getTimeInMillis();
        long remain = m2 - m1;

        // 天
        long day = remain / 24 / 60 / 60 / 1000;
        if (day > 0)
            sb.append(day + "天");

        // 小时
        remain -= (day * 24 * 60 * 60 * 1000);
        long hour = remain / 60 / 60 / 1000;
        if (hour > 0 || sb.length() > 0)
            sb.append(hour + "时");

        // 分
        remain -= (hour * 60 * 60 * 1000);
        long minute = remain / 60 / 1000;
        if (minute > 0 || sb.length() > 0)
            sb.append(minute + "分");

        return sb.toString();
    }

    /**
     * 获取当前时间一小时后的时间
     */
    public static Date getOneHourAfterTime() {
        Calendar clender = Calendar.getInstance();
        clender.add(Calendar.HOUR_OF_DAY, 1);
        return clender.getTime();
    }

    /**
     * 获取当前日期，没有时分秒的
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar c = Calendar.getInstance();
        clearTimes(c);
        return c.getTime();
    }

    /**
     * 两个时间比较;d1>d2?true:false 出现异常就返回false
     *
     * @param d1
     * @param d2
     * @return
     */
    public static final boolean dateCompare(Date d1, Date d2) {
        if (d1 == null || d2 == null)
            return false;
        try {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(d1);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(d2);

            long p1 = c1.getTimeInMillis();
            long p2 = c2.getTimeInMillis();
            if (p1 > p2)
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 获得当前时间的全字符串yyyyMMddhhmmss
     *
     * @return
     */
    public static final String getNowDateTimeStr() {

        return DateTime.now().toString("yyyyMMddHHmmss");
    }

    /**
     * 获得当前时间的字符串yyyyMMdd
     *
     * @return
     */
    public static final String getNowDateStr() {

        return DateTime.now().toString("yyyyMMdd");
    }

    /**
     * 获得当前时间的int类型yyyyMMdd
     *
     * @return
     */
    public static final int getNowDate() {

        return Integer.valueOf(DateTime.now().toString("yyyyMMdd"));
    }

    /**
     * 获得当前时间的字符串yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getNowDateFormat() {

        return DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获得昨天的int类型yyyyMMdd
     *
     * @return
     */
    public static int getYesterdayDate() {
        return Integer.valueOf(DateTime.now().plusDays(-1).toString("yyyyMMdd"));
    }

    /**
     * 获得当前时间戳
     *
     * @return
     */
    public static final long getNow() {

        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间附近小时的时间
     */
    public static Date getTimeByHours(int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public static Map<String, Long> getRangeByStr(String yyyyMMdd) {

        Date date = null;
        try {
            date = DateUtils.parseDate(yyyyMMdd, "yyyyMMdd");
        } catch (ParseException e) {

            log.error("日期转换出错：e = {}", ExceptionUtils.getStackTrace(e));
        }
        return getRangeByDate(date);
    }

    public static Map<String, Long> getRangeByDate(Date date) {

        long minTime = new DateTime(date)  //
            .hourOfDay()    //
            .withMinimumValue() //
            .minuteOfHour() //
            .withMinimumValue() //
            .secondOfMinute()   //
            .withMinimumValue() //
            .getMillis();   //
        long maxTime = new DateTime(date)  //
            .hourOfDay()    //
            .withMaximumValue() //
            .minuteOfHour() //
            .withMaximumValue() //
            .secondOfMinute()   //
            .withMaximumValue() //
            .getMillis();   //

        Map<String, Long> timeMap = Maps.newHashMap();
        timeMap.put("minTime", minTime);
        timeMap.put("maxTime", maxTime);

        return timeMap;
    }
    //1490112000000
    public static Long getTodayTimestamp(Long timestamp){
        return null;
    }

    public static Integer formatDateInteger(Long timestamp){
        String time = new SimpleDateFormat("yyyyMMdd").format(timestamp);
        return Integer.valueOf(time);
    }

    public static void main(String[] args) {
        Integer a = DateUtil.formatDateInteger(Long.valueOf(1490112000000l));
        String s = formatDateString(1490112000000l);
        Integer i = formatDateInteger(1490112000000l);
        Long o = DateUtil.formatMillis("20170322", "yyyyMMdd");
        System.out.println(a);
        System.out.println(s);
        System.out.println(i);
        System.out.println(o);

    }

    public static boolean isScopeByThreeMonth(Integer createDay){
        Integer today = Integer.valueOf(DateTime.now().toString("yyyyMMdd"));
        Integer threeMonth = Integer.valueOf(DateTime.now().plusMonths(-3).toString("yyyyMMdd"));

        return createDay >= threeMonth && createDay < today;
    }

    /**
     * 把时间字符串转时间戳
     *
     * @param time
     * @return
     */
    public static Long formatMillis(String time, String formatType) {
        DateFormat format = new SimpleDateFormat(formatType);
        Date date;
        try {
            date = format.parse(time);
            return date.getTime();
        } catch (ParseException e) {
            return null;
        }
    }
}
