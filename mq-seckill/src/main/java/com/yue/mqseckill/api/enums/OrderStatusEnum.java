package com.yue.mqseckill.api.enums;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 16:41
 */
public enum OrderStatusEnum {

    paying("待付款"),
    prePost("已付款，代发货"),
    posting("发货中"),
    distributing("配送中"),
    over("完成");

    private String statusName;

    OrderStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
