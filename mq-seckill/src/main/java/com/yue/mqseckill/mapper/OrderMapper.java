package com.yue.mqseckill.mapper;

import com.yue.mqseckill.api.entity.SeckillOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 16:36
 */
public interface OrderMapper {
    void addOrder(@Param("seckillOrder") SeckillOrder seckillOrder);

    void handleFailureOrder(@Param("seckillOrder") SeckillOrder seckillOrder);
}
