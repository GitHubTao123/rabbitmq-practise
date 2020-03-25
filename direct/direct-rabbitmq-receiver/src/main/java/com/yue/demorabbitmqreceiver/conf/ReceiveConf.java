package com.yue.demorabbitmqreceiver.conf;

import com.yue.demorabbitmqreceiver.entity.MyUser;
import com.yue.demorabbitmqreceiver.mapper.MyUserDao;
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

    @RabbitListener(queues = "queue")
    public void processC(String str){
        MyUser myUser = myUserDao.selectById(Integer.parseInt(str));
        System.out.println("receive: "+myUser.toString());
    }
}
