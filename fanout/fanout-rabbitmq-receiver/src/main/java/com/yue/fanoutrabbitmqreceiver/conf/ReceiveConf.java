package com.yue.fanoutrabbitmqreceiver.conf;

import com.yue.fanoutrabbitmqreceiver.entity.MyUser;
import com.yue.fanoutrabbitmqreceiver.mapper.MyUserDao;
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

    @RabbitListener(queues = "fanout.A")
    public void processA(String str){
        MyUser myUser = myUserDao.selectById(Integer.parseInt(str));
        System.out.println("receive.A: "+myUser.toString());
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String str){
        MyUser myUser = myUserDao.selectById(Integer.parseInt(str));
        System.out.println("receive.B: "+myUser.toString());
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String str){
        MyUser myUser = myUserDao.selectById(Integer.parseInt(str));
        System.out.println("receive.C: "+myUser.toString());
    }

}
