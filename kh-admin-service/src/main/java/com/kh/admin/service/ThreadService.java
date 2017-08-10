package com.kh.admin.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 20:22 2017/8/3
 */
@Service
public class ThreadService {

    @Resource
    private RedisService redisService;


    static class Producer implements Runnable{

        @Override
        public void run() {
            System.out.println("生产者运行");
            Jedis jedis = new Jedis("127.0.0.1");

            while (true) {

                UUID uuid = UUID.randomUUID();

                jedis.lpush("task",uuid.toString());

                System.out.println("生产者插入了一个新任务" + uuid);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    static class Comsumer implements Runnable{

        @Override
        public void run() {

            while (true) {
                System.out.println("消费者开始执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Jedis jedis = new Jedis("127.0.0.1");

                String taskId = jedis.rpoplpush("task", "list");

                String list = jedis.lpop("list");
                System.out.println(taskId);
                System.out.println("POP" + list);
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Comsumer()).start();
    }

    public void del(){
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.del("task");
        jedis.del("list");

    }

}

