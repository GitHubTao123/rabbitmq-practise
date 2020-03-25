package com.yue.directrabbitmqsender;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.directrabbitmqsender.mapper")
@SpringBootApplication
public class DirectRabbitmqSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectRabbitmqSenderApplication.class, args);
    }

}
