package com.kh.admin.model;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 所在的包名: com.kh.admin.model
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 10:07 2017/8/10
 */
public class Publisher implements Runnable{

    private final String channel = "mychannel";

    private final JedisPool jedisPool;

    public Publisher() {
        jedisPool = null;
    }


    @Override
    public void run() {
        /*Jedis jedis = new Jedis("127.0.0.1");

        jedis.publish("mychannel", "this is midone");*/


        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.publish(channel,"this is my house");
        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
