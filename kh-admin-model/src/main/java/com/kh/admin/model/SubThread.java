package com.kh.admin.model;

import redis.clients.jedis.Jedis;

/**
 * 所在的包名: com.kh.admin.model
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 10:04 2017/8/10
 */
public class SubThread implements Runnable {

    private final Subscriber subscriber = new Subscriber();

    private final String channel = "mychannel";

    @Override
    public void run(){
        /*Jedis jedis = new Jedis("127.0.0.1");
        jedis.subscribe(subscriber,channel);*/

        Jedis jedis = null;
        try {
            jedis = new Jedis("127.0.0.1");
            jedis.subscribe(subscriber, channel);
        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }
}
