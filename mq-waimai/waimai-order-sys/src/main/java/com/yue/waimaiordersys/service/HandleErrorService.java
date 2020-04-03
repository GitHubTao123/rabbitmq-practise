package com.yue.waimaiordersys.service;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/2 17:52
 */
public interface HandleErrorService {

    boolean handleOrderError(String exchangeName, String queueName, long orderId);

    void handleOrderNotReach(String exchange, String routingKey, String s);
}
