package com.yue.mqseckill.api.entity;

import com.yue.mqseckill.api.dto.CommitOrderDto;
import com.yue.mqseckill.api.enums.OrderStatusEnum;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 16:39
 */
@Data
public class SeckillOrder extends CommitOrderDto implements Serializable {

    private int id;
    private BigDecimal totalPrice;
    private OrderStatusEnum statusEnum;

    public SeckillOrder(@NotNull int userId, @NotNull String targetAddr, @NotNull int goodId, @Min(1) long count, int id, BigDecimal totalPrice, OrderStatusEnum statusEnum) {
        super(userId, targetAddr, goodId, count);
        this.id = id;
        this.totalPrice = totalPrice;
        this.statusEnum = statusEnum;
    }

    public SeckillOrder(BigDecimal totalPrice, OrderStatusEnum statusEnum) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.statusEnum = statusEnum;
    }

    public SeckillOrder(){
        super();
    }
}
