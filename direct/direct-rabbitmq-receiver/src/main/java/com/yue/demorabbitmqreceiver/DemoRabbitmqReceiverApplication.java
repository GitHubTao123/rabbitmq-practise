package com.yue.demorabbitmqreceiver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.demorabbitmqreceiver.mapper")
@SpringBootApplication
public class DemoRabbitmqReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitmqReceiverApplication.class, args);
    }

}
