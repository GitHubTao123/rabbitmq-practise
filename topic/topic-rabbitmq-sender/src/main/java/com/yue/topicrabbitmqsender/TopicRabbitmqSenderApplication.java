package com.yue.topicrabbitmqsender;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.topicrabbitmqsender.mapper")
@SpringBootApplication
public class TopicRabbitmqSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopicRabbitmqSenderApplication.class, args);
    }

}
