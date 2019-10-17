package com.springboot_vue.js.past;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate = null;


    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;


    @RequestMapping("/stringandhash")
    @ResponseBody
    public Map<String, Object> teststringandhash (){
//        redisTemplate.opsForValue.set("key1" , "value1");
        redisTemplate.opsForValue().set("key1","value1");
        redisTemplate.opsForValue().set("int_num" , "1");
        Map<String, String> hash = new HashMap<>();
        hash.put("hash1" ,"zczc");
        hash.put("hash2", "czcz");
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }






}
