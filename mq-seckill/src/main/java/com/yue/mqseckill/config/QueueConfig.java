//package com.yue.mqseckill.config;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: lsSaitaoYue
// * @Create: 2020/3/25 14:49
// */
//@Configuration
//public class QueueConfig {
//
//    public static final String ORDER_QUEUE = "order-queue";
//    public static final String QUEUE_NAME2 = "second-queue";
//    public static final String QUEUE_NAME3 = "third-queue";
//
//    @Bean
//    public Queue orderQueue(){
//        return new Queue(ORDER_QUEUE);
//    }
//
//    @Bean
//    public Queue secondQueue(){
//        return new Queue(QUEUE_NAME2);
//    }
//
//    @Bean
//    public Queue thirdQueue(){
//        //配置自动删除
//        Map<String,Object> arguments = new HashMap<>();
//        arguments.put("x-message-ttl",60000);//60秒自动删除
//        return new Queue(QUEUE_NAME3,true,false,true,arguments);
//    }
//}
