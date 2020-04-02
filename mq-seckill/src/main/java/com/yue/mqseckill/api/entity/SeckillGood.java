package com.yue.mqseckill.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 16:13
 */
@Data
public class SeckillGood implements Serializable {

    private int id;
    private String goodName;
    private long stock;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
