package com.kh.admin.service; /**
 * Created by Administrator on 2017/7/24.
 */

import com.kh.admin.common.utils.ResourceUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.testng.annotations.Test;


/**
 * @author xukh
 * @create 2017-07-24-20:56
 */
public class RedisServiceTest extends BaseTest{

    @Test
    public void test(){
        System.out.println("--------------------111111111111--------------------");
    }

    @Test
    public void test1(){
        String system = ResourceUtil.getSystem("resource.test");
        System.out.println(system);
    }

    @Test
    public void test2(){
        String province = "香港特别行政区";
        String city = "中西區";
        String district = "";
        if(StringUtils.equals(province,"香港特别行政区") || StringUtils.equals(province,"澳门特别行政区")){
            district = city;
            city = province;
            province = "1";         //1.代表中华人名共和国
        }

        System.out.println(province + "   " + city + "   " + district);
    }

    @Test
    public void test3(){
        DateTime now = DateTime.now();
        System.out.println(now.toString());
        Integer createDate = Integer.valueOf(DateTime.now().plusDays(-1).toString("yyyyMMdd"));
        System.out.println(createDate);
    }
}
