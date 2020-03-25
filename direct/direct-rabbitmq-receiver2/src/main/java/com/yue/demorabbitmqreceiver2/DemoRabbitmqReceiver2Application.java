package com.yue.demorabbitmqreceiver2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.demorabbitmqreceiver2.mapper")
@SpringBootApplication
public class DemoRabbitmqReceiver2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitmqReceiver2Application.class, args);
    }

}
