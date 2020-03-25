package com.yue.directrabbitmqsender.mapper;

import com.yue.directrabbitmqsender.entity.MyUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:18
 */
public interface MyUserDao {
    void insertUser(@Param("myUser") MyUser myUser);
}
