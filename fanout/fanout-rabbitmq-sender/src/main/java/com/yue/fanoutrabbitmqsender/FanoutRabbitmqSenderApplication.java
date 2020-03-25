package com.yue.fanoutrabbitmqsender;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.fanoutrabbitmqsender.mapper")
@SpringBootApplication
public class FanoutRabbitmqSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanoutRabbitmqSenderApplication.class, args);
    }

}
