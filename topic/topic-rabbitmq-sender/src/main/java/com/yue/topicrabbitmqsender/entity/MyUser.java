package com.yue.topicrabbitmqsender.entity;

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

    public MyUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
