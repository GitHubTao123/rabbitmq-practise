package com.yue.demorabbitmqreceiver2.conf;

import com.yue.demorabbitmqreceiver2.entity.MyUser;
import com.yue.demorabbitmqreceiver2.mapper.MyUserDao;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
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
