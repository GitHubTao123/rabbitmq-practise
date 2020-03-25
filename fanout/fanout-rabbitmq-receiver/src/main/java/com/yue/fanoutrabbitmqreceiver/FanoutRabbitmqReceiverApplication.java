package com.yue.fanoutrabbitmqreceiver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.fanoutrabbitmqreceiver.mapper")
@SpringBootApplication
public class FanoutRabbitmqReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanoutRabbitmqReceiverApplication.class, args);
    }

}
