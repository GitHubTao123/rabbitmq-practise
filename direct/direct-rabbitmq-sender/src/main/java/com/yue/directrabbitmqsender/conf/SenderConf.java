package com.yue.directrabbitmqsender.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:13
 */
@Configuration
public class SenderConf {
    @Bean
    public Queue queue(){
        return new Queue("queue");
    }
}
