package com.yue.directrabbitmqsender.controller;

import com.yue.directrabbitmqsender.entity.MyUser;
import com.yue.directrabbitmqsender.mapper.MyUserDao;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/sendMsg")
    public void sendMsg(@RequestBody MyUser myUser){
        myUserDao.insertUser(myUser);
        amqpTemplate.convertAndSend("queue",myUser.getId());
    }
}
