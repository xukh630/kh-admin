package com.kh.admin.model;

import redis.clients.jedis.JedisPubSub;

/**
 * 所在的包名: com.kh.admin.model
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 23:53 2017/8/7
 */
public class Subscriber extends JedisPubSub {
    public Subscriber() {
    }

    //此处接收消息
    public void onMessage(String channel, String message) {
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
    }

    //阻塞方法
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d", channel, subscribedChannels));
    }

    //取消订阅
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d", channel, subscribedChannels));

    }
}
