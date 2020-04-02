package com.yue.mqseckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yue.mqseckill.mapper")
@SpringBootApplication
public class MqSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqSeckillApplication.class, args);
    }

}
