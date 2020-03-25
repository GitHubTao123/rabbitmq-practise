package com.yue.topicrabbitreceiver.conf;

import com.yue.topicrabbitreceiver.entity.MyUser;
import com.yue.topicrabbitreceiver.mapper.MyUserDao;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:49
 */
@Component
public class ReceiveConf {

    @Autowired
    private MyUserDao myUserDao;

    @RabbitListener(queues = "topic.message")
    public void process1(String str){
        MyUser myUser = myUserDao.selectById(Integer.parseInt(str));
        System.out.println("receive1: "+myUser.toString());
    }

    @RabbitListener(queues = "topic.messages")
    public void process2(String str){
        MyUser myUser = myUserDao.selectById(Integer.parseInt(str));
        System.out.println("receive2: "+myUser.toString());
    }
}
