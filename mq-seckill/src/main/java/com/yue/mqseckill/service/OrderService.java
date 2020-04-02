package com.yue.mqseckill.service;

import com.yue.mqseckill.api.dto.CommitOrderDto;
import com.yue.mqseckill.result.Result;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 15:47
 */
public interface OrderService {
    Result commit(CommitOrderDto dto);

    void readStockFromMysql();
}
