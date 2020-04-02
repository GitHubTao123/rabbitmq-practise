package com.yue.mqseckill.controller;

import com.alibaba.fastjson.JSON;
import com.yue.mqseckill.api.dto.CommitOrderDto;
import com.yue.mqseckill.api.entity.SeckillOrder;
import com.yue.mqseckill.result.Result;
import com.yue.mqseckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 14:57
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
//    private AmqpTemplate amqpTemplate;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private OrderService orderService;

    /**
     * 保存order，同时向store服务器发送通知减库存
     */
    @PostMapping("/save")
    public SeckillOrder saveOrder(@RequestBody SeckillOrder seckillOrder){
        log.info(seckillOrder.toString());
        String json = JSON.toJSONString(seckillOrder);
        String msgId = UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend("fitst_exchange","queue_one_key1",json,new CorrelationData(msgId));
        return seckillOrder;
    }

    @PostMapping("/commit")
    public Result commit(@RequestBody CommitOrderDto dto){
        //1. 验证cookie登录信息

        //2. 发送消息
        return orderService.commit(dto);
    }

    @GetMapping("/readStockFromMysql")
    public void readStockFromMysql(){
        orderService.readStockFromMysql();
    }
}
