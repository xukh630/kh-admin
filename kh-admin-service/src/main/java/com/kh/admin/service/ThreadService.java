package com.kh.admin.service;

import com.kh.admin.model.Subscriber;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int i =0;

            while (true) {
                UUID uuid = UUID.randomUUID();

                jedis.lpush("task",uuid.toString() + "------"  + i);

                System.out.println("生产者插入了一个新任务" + uuid.toString() + "------"  + i);


                i ++;
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


      /* new Thread(new Sub()).start();
       new Thread(new Pub()).start();*/
    }

    public void del(){
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.del("task");
        jedis.del("list");

    }

    static class Sub implements Runnable {

        @Override
        public void run() {

            System.out.println(String.format("subscribe redis, channel %s, thread will be blocked", "mychannel"));
            Jedis jedis = null;
            try {
                jedis = new Jedis("127.0.0.1");
                Subscriber subscriber = new Subscriber();
                jedis.subscribe(subscriber, "mychannel");
            } catch (Exception e) {
                System.out.println(String.format("subsrcibe channel error, %s", e));
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }

    static class Pub implements Runnable {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Jedis jedis = new Jedis("127.0.0.1");
            String line = null;
            try {
                line = reader.readLine();
                if (!"quit".equals(line)) {
                    jedis.publish("mychannel", line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

