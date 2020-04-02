package com.yue.directrabbitmqsender.service.impl;

import com.yue.directrabbitmqsender.conf.DirectSender;
import com.yue.directrabbitmqsender.entity.MyUser;
import com.yue.directrabbitmqsender.mapper.MyUserDao;
import com.yue.directrabbitmqsender.service.MyUserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/2 11:04
 */
@Service
public class MyUserServiceImpl implements MyUserService {

    @Autowired
    private DirectSender directSender;
    @Autowired
    private MyUserDao myUserDao;

    @Override
    public void sendMsg(MyUser myUser){
        myUserDao.insertUser(myUser);
        directSender.send("queue-1",myUser.getId());
    }
}
