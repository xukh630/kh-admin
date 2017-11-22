package com.kh.admin.model;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 所在的包名: com.kh.admin.model
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 21:56 2017/8/14
 */
public class PubSubDemo {

    public static void main( String[] args )
    {

        String redisIp = "127.0.0.1";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

        SubThread subThread = new SubThread(jedisPool);
        subThread.start();

        Publisher publisher = new Publisher(jedisPool);
        publisher.start();
    }
}
