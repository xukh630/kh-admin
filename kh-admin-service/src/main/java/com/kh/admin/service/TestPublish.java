package com.kh.admin.service;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 23:11 2017/8/7
 */
public class TestPublish {

    @Test
    public void testPublish() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.publish("redisChatTest","我是天才");
        Thread.sleep(5000);
        jedis.publish("redisChatTest","我牛逼");
        Thread.sleep(5000);
        jedis.publish("redisChatTest","哈哈");
    }
}
