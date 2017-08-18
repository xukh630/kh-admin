package com.kh.admin.service;/**
 * Created by Administrator on 2017/7/19.
 */

import com.kh.admin.common.result.ResultModle;
import com.kh.admin.common.utils.ResourceUtil;
import com.kh.admin.model.Publisher;
import com.kh.admin.model.SubThread;
import com.kh.admin.model.Subscriber;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author xukh
 * @create 2017-07-19-20:38
 */
@Service
public class RedisService {

    @Resource
    JedisConnectionFactory jedisConnectionFactory;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    Jedis jedis;
//Redis连接----------------jedis-------------------------------------------------------------------------------------------------------------------------
    //连接redis 1
    public void redisConnect1(){
       //连接redis
        String host = ResourceUtil.getSystem("redis.host");
        String port = ResourceUtil.getSystem("redis.port");

        jedis = new Jedis(host,Integer.valueOf(port));
        jedis.set("connect1","connect1");
    }

    //stringRedisTemplate
    public void redisConnect2(){
        ValueOperations<String, String> redis = stringRedisTemplate.opsForValue();
        redis.set("connect2","connect2");
    }

   //jedisConnectionFactory
    public void redisConnect3(){
        jedis = jedisConnectionFactory.getShardInfo().createResource();
        jedis.set("connect3","connect3");

    }
//Redis---------Map----CRUD----------------------------------------------------------------------------------------------------------
   public void testMap(){
        //添加数据
       jedis.set("map1","xukh");
       jedis.set("map2","10");
       jedis.set("map3","666");
       //拼接数据
       jedis.append("map1","厉害");
       //设置多个键值对
       jedis.mset("a","a1","b","b1","c","c1");

       //删除某个键
       jedis.del("c");

   }
//Redis连接-------自增------------------------------------------------------------------------------------------------------------
   public void test(){

       jedis.incr("age");
       jedis.incr("number");
       jedis.set("No","20");
       jedis.incr("No");
   }

   public void close(){
       jedis.set("close","2");
       jedis.close();           //close没起作用
       jedis.set("open","1");

   }
//Redis--------------移除所有(此方法无效)-----------------------------------------------------------------------------------------------------
    public void removeAll(){
       jedis.del("java framework");
        jedis.lrange("java framework",0,-1);
    }
//Redis--------------List-------------------lindex-list1-0----------------------------------------------------------------------------------

    /**
     * lpush 插入头    rpush插尾     lpushx    rpushx
     * linsert - after/before -
     * lindex key index
     * lset key index value
     * lrem 移除
     * llen 取长度
     */
    public void listTest(){
       jedis.lpush("list1","list1");
       jedis.lpush("list1","list11");           //添加到表头
       jedis.rpush("list1","list111");
       jedis.rpush("list1","7","8");
       //修改
       jedis.lset("set",0,"first");
       //删除
       jedis.ltrim("set",0,1);
       int count = 1;   //count > 0 从头移除count个    count=0 移除所有   count < 0 从尾开始移除count个
       jedis.lrem("set",count,"1");
       //获取长度
       jedis.llen("set");
   }

   //获取list中的值
   public void getListTest(){
        //获取指定索引的元素
       String list12 = jedis.lindex("list1", 1);
       System.out.println(list12);
       List<String> list1 = jedis.lrange("list1", 0, 0);
       System.out.println(list1);
       List<String> list11 = jedis.lrange("list1", 0, -1);
       System.out.println(list11);
   }
//Redis----------------set---------------------------------------------------------------------------------------------------

    /**
     * sadd         增加元素
     * smembers     获取所有元素
     * sismember    判断元素是否存在
     * scard        获取元素个数
     * srandmember  随机返回一个元素
     * spop         移除元素并随机返回一个元素
     * srem         移除一个或多个元素
     */
    public void setTest(){
       jedis.sadd("set","1","0");
       jedis.sadd("set","2");
       jedis.sadd("set","3");
       jedis.sadd("set","4");
       Set<String> set = jedis.smembers("set");
       System.out.println(set);
       Boolean a = jedis.sismember("set","0");
       Boolean b = jedis.sismember("set","1");
       System.out.println(a);
       System.out.println(b);
       String random = jedis.srandmember("set");
       System.out.println(random);
       Long number = jedis.scard("set");
       System.out.println(number);

   }

   //对比差异数据
   public void setDiff(){
       jedis.sadd("set1","1","2","3","4","5","6","7");
       jedis.sadd("set2","5","6","7","8","9","10");
       Set<String> sdiff1 = jedis.sdiff("set1", "set2");
       Set<String> sdiff2 = jedis.sdiff("set2", "set1");
       System.out.println(sdiff1);
       System.out.println(sdiff2);
       Iterator<String> iterator = sdiff1.iterator();
       while (iterator.hasNext()) {
           System.out.println(iterator.next());
       }

   }

//Redis-----------------生命周期---------------------------------------------------------------------------------------------
   public void live(){
       stringRedisTemplate.opsForValue().set("file","1",1, TimeUnit.MINUTES);

   }

    /**设置生命周期
     * expire             秒
     * pepxpire           毫秒
     * expireat           秒级时间戳
     * pexpireat          毫秒级时间戳
     */
   public void liv(){
       String time = jedis.set("time", "20170725");
       jedis.expire("time",20);
   }

//Redis--------------发布订阅---------------------------------------------------------------------------------------------------------------------

    //普通订阅subscribe  A  B    订阅类型   订阅频道   订阅数量
    //频道发布publish    A  B    发布A频道  B 信息
    //模式订阅psubscribe
    //查看订阅信息pubsub

    public static void producer(){
        Jedis jedis1 = new Jedis("127.0.0.1");      //jedis 线程不安全    jedispool线程安全
        Jedis jedis2 = new Jedis("127.0.0.1");
        Jedis jedis3 = new Jedis("127.0.0.1");

        Subscriber subscriber = new Subscriber();
        //接收者   订阅两个频道
        jedis1.subscribe(subscriber,"channel1","channel2");             //线程阻塞的
        //两个发布者  发布消息
        jedis2.publish("channel1","this is channel1");
        jedis3.publish("channel2","this is channel2");


        String key = "key";
        String liquidatorId = "liquidatorId";

        String redisKey = key + liquidatorId + "Lock";




    }

    public ResultModle redisTemplate(){
        String redisKey = "redisKey";

        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(redisKey, "1");

        if (!aBoolean) {
            return ResultModle.commonError("redisKey已存在");
        }

        stringRedisTemplate.opsForValue().set("redisKey","1");
        return ResultModle.success("true");
    }

}
