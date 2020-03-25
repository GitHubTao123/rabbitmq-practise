package com.yue.fanoutrabbitmqreceiver.entity;

import lombok.Data;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/24 15:17
 */
@Data
public class MyUser {

    private int id;

    private String name;

    private int age;

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
