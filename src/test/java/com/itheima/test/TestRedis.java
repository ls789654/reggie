package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author LuSheng
 * @title: TestRedis
 * @projectName reggie_day06
 * @description: TODO
 * @date 2023/2/2415:52
 */
/**@RunWith(SpringRunner.class)的作用表明Test测试类要使用注入的类，
 * 比如@Autowired注入的类，
 * 有了@RunWith(SpringRunner.class)这些类才能实例化到spring容器中，
 * 自动注入才能生效*/

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {

    //RedisTemplate由Springboot自动装配，只要在yml中有Redis就会自动装配
    //RedisTemplate会默认序列化方式 city->"\xac\xed\x00\x05t\x00\x04city"
    //StringRedisTemplate 正常
    //springRedisTemplate合适存字符串，而RedisTemplate存取对象不用转换
    @Autowired
    //private StringRedisTemplate redisTemplate;
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void testString() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("city", "nanjing");
    }


    @Test
    public void testHash() {
        HashOperations<String, Object, Object> ha = redisTemplate.opsForHash();
        ha.put("002", "name", "zhangsan");
        ha.put("002", "age", "20");
        String object = (String) ha.get("002", "age");
        System.out.println(object);
    }


    @Test
    public void testList() {
        ListOperations<String, String> list = redisTemplate.opsForList();
        list.leftPush("AAA", "DDD");
        list.leftPush("AAA", "CCC");
        List<String> aaa = list.range("AAA", 0, -1);

        System.out.println(aaa);
    }

    /**
     * @return
     * @author LuSheng
     * @Description
     * @Date 16:36 2023/2/24
     * @Param opsForset       add           remove       members() 返回Set
     **/


    @Test
    public void Zset() {
        ZSetOperations<String, String> ZSetOperations = redisTemplate.opsForZSet();
        ZSetOperations.add("AAA", "DDD", 10.0);
        ZSetOperations.add("AAA", "ccc", 10.0);

        //修改分数
        ZSetOperations.incrementScore("AAA", "ccc", 20.0);

    }

    /**
     *通用操作，针对不同的数据类型都可以操作
     */
    @Test
    public void testCommon() {
        //获取Redis中所有的key
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        //判断某个key是否存在
        Boolean itcast = redisTemplate.hasKey(" itcast");
        System.out.println(itcast);
    //删除指定key
        redisTemplate.delete("myZset");
    //获取指定key对应的value的数据类型
        DataType dataType = redisTemplate.type("myset");
        System.out.println(dataType.name());

    }
}