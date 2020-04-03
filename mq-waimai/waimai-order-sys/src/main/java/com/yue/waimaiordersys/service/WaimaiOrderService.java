package com.yue.waimaiordersys.service;

import com.yue.waimaiordersys.api.entity.WaimaiOrder;

import java.util.List;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 10:28
 */
public interface WaimaiOrderService {
    WaimaiOrder selectById(long orderId);

    boolean insert(WaimaiOrder waimaiOrder);

    List<WaimaiOrder> getOrderByConsumerId(int userId);
}
