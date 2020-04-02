package com.yue.mqseckill.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 14:53
 */
@Configuration
public class RabbitMqConfig {
//
//    @Autowired
//    private QueueConfig queueConfig;
//    @Autowired
//    private ExchangeConfig exchangeConfig;

    @Bean(name = "directQueue")
    Queue directQueue(){
        return new Queue("direct.A");
    }

//    @Bean
//    public Binding binding(@Qualifier("directQueue") Queue directQueue){
//        return BindingBuilder.bind(directQueue).to();
//        return BindingBuilder.bind(queueConfig.orderQueue()).to(new DirectExchange(""));
//    }
}
