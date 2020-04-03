package com.yue.waimaiserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@EnableFeignClients
@MapperScan("com.yue.waimaiserver.mapper")
@SpringBootApplication
public class WaimaiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaimaiServerApplication.class, args);
    }

}
