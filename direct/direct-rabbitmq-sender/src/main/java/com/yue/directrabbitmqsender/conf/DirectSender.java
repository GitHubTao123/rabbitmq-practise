package com.yue.directrabbitmqsender.conf;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:13
 */
@Component
public class DirectSender{

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String queueName,Object message){
        String json = JSONObject.toJSONString(message);
//        CorrelationData correlationData = new CorrelationData(""+System.currentTimeMillis());
        rabbitTemplate.convertAndSend(queueName,json);
    }
}