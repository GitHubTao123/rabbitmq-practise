package com.yue.fanoutrabbitmqsender.mapper;

import com.yue.fanoutrabbitmqsender.entity.MyUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:18
 */
public interface MyUserDao {
    void insertUser(@Param("myUser") MyUser myUser);
}
