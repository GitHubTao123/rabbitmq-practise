package com.yue.directrabbitmqreceiver.conf;

import com.rabbitmq.client.Channel;
import com.yue.directrabbitmqreceiver.entity.MyUser;
import com.yue.directrabbitmqreceiver.mapper.MyUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:49
 */
//@RabbitListener(
//        bindings = {
//                @QueueBinding(value = @Queue(value = "queue-1"),
//                        exchange = @Exchange(value = "exchange-1"))
//        }
//)
@Component
public class ReceiveConf {

    @Autowired
    private MyUserDao myUserDao;

    private Logger log = LoggerFactory.getLogger(ReceiveConf.class);

//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "queue-1", durable = "true"),
//            exchange = @Exchange(value = "exchange-1",durable = "true")))
    @RabbitListener(queues = "queue-1")
    public void onMessage(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        MyUser myUser = myUserDao.selectById(Integer.parseInt(new String(message.getBody())));
        log.info("receive: "+myUser.toString());
    }

}
