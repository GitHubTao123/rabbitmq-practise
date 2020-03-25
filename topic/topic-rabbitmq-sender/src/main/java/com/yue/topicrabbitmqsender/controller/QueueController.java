package com.yue.topicrabbitmqsender.controller;

import com.yue.topicrabbitmqsender.entity.MyUser;
import com.yue.topicrabbitmqsender.mapper.MyUserDao;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:15
 */
@RestController
public class QueueController {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private MyUserDao myUserDao;

    @GetMapping(value = "/sendMsg")
    public void sendMsg() {
        MyUser myUser1 = new MyUser("Tom",20);
        MyUser myUser2 = new MyUser("Jerry",10);
        myUserDao.insertUser(myUser1);
        myUserDao.insertUser(myUser2);
        amqpTemplate.convertAndSend("exchange","topic.message", myUser1.getId());
        amqpTemplate.convertAndSend("exchange","topic.messages", myUser2.getId());
    }
}
