package com.yue.topicrabbitreceiver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.topicrabbitreceiver.mapper")
@SpringBootApplication
public class TopicRabbitReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopicRabbitReceiverApplication.class, args);
    }

}
