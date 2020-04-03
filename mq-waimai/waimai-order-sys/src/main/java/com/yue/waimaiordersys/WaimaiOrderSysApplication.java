package com.yue.waimaiordersys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.waimaiordersys.mapper")
@SpringBootApplication
public class WaimaiOrderSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaimaiOrderSysApplication.class, args);
    }

}
