package com.yue.directrabbitmqreceiver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.directrabbitmqreceiver.mapper")
@SpringBootApplication
public class DirectRabbitmqReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectRabbitmqReceiverApplication.class, args);
    }

}
