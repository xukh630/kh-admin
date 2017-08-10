package com.kh.admin.service;

import com.kh.admin.model.RedisSubListener;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 23:07 2017/8/7
 */
public class testSubscribe {

    @Test
    public void testSubscribe() {
        Jedis jedis = new Jedis("127.0.0.1");
        RedisSubListener listener = new RedisSubListener();
        jedis.subscribe(listener,"redisChatTest");
    }
}
