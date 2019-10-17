package com.springboot_vue.js;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @Autowired
    private RedisTemplate redisTemplate = null;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    private void initRedisTemplate(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }


//SessionCallback

    @Test
    public void testLua(){


        String key1 = "11";
        String key2 = "22";
        String value1 = "11's value";
        String value2 = "22's value";

        String lua = "redis.call('set', KEYS[1], ARGV[1])\n"
                    + "redis.call('set', KEYS[1], ARGV[1])\n"
                    + "local str1 = redis.call('get', KEYS[1])\n"
                    + "local str2 = redis.call('get', KEYS[2])\n"
                    + "if str1 == str2 then \n"
                    + "return 1 \n"
                    + "end \n"
                    + "return 0 \n";

        System.out.println(lua);

        DefaultRedisScript<Long> rs = new DefaultRedisScript<>();
        rs.setScriptText(lua);
        rs.setResultType(Long.class);  //这里一定要定义类型 意思是结果返回为long类型的

        RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();

        List<String> keylist = new ArrayList();
        keylist.add(key1);
        keylist.add(key2);

        Long result = (Long) redisTemplate.execute(rs, redisSerializer, redisSerializer, keylist, value1, value2);

        System.out.println(result);
//        return null;

    }





}



