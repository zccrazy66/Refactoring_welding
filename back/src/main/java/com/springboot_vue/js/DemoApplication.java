package com.springboot_vue.js;

import com.springboot_vue.js.util.RedisMessageListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@MapperScan("com.springboot_vue.js.Dao")
@EnableCaching  //启用缓存机制
public class DemoApplication {


    @Autowired
    private RedisConnectionFactory redisConnectionFactory = null; //连接工厂
//
//    @Autowired
//    private MessageListener redismsglistener = null;
//
//    @Autowired
//    private ThreadPoolTaskScheduler taskScheduler = null;        //任务池

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



//
//    /**
//        创建任务池
//     */
//    @Bean
//    public ThreadPoolTaskScheduler initTaskScheduler(){
//        if (taskScheduler != null){return taskScheduler;}
//
//        taskScheduler =new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(20);
//        return taskScheduler;
//    }
//
//    /**
//        定义redis的监听容器
//     */
//
//    @Bean
//    public RedisMessageListenerContainer initRedisContainer(){
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
////        连一波工厂
//        container.setConnectionFactory(redisConnectionFactory);
////        要一个任务池
//        container.setTaskExecutor(initTaskScheduler());
////        定义一个监听的渠道
//        Topic topic = new ChannelTopic("zc");
//
//        container.addMessageListener(redismsglistener, topic);
//        return container;
//    }
//    *************************************************************
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
