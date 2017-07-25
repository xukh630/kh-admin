package com.kh.admin.common.utils;



import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 * Created by Administrator on 2017/3/10.
 */
public class RandomNumberUtil {

    /**
     * 生成22位随机数字符串
     * @return
     */
    public static String createRoleId(){
        StringBuffer sb = new StringBuffer();
        //拼接时间字符串
        sb.append(DateUtil.getNowDateStr());
        //获得6位随机数字
        sb.append(RandomStringUtils.randomNumeric(8));

        return sb.toString();
    }

    /**
     * 生成一个记录id(目前30位)
     * 20160809104636 02 234610196920
     * 14位日期 16位随机数字
     *
     * @return
     */
    public static String createDataId() {
        StringBuffer sb = new StringBuffer();
        // 获得时间字符串
        sb.append(DateUtil.getNowDateTimeStr());

        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        sb.append(String.format("%010d", hashCodeV));

        return sb.toString();
    }

    public static String createCustId(){
        StringBuffer sb = new StringBuffer();
        //拼接时间字符串
        sb.append(DateUtil.getNowDateStr());
        //获得6位随机数字
        sb.append(RandomStringUtils.randomNumeric(24));

        return sb.toString();
    }
}
