package com.yue.demorabbitmqreceiver.mapper;


import com.yue.demorabbitmqreceiver.entity.MyUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:18
 */
public interface MyUserDao {

    MyUser selectById(@Param("id") int id);
}
