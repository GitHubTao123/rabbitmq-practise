package com.yue.directrabbitmqsender.service;

import com.yue.directrabbitmqsender.entity.MyUser;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/2 11:03
 */
public interface MyUserService {
    void sendMsg(MyUser myUser);
}
