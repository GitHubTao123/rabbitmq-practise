package com.yue.mqseckill.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yue.mqseckill.api.dto.CommitOrderDto;
import com.yue.mqseckill.api.entity.SeckillGood;
import com.yue.mqseckill.api.entity.SeckillOrder;
import com.yue.mqseckill.api.enums.OrderStatusEnum;
//import com.yue.mqseckill.config.ExchangeConfig;
//import com.yue.mqseckill.config.QueueConfig;
import com.yue.mqseckill.constant.OrderConstant;
import com.yue.mqseckill.mapper.GoodMapper;
import com.yue.mqseckill.mapper.OrderMapper;
import com.yue.mqseckill.result.CodeMsg;
import com.yue.mqseckill.result.Result;
import com.yue.mqseckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 15:48
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 加事务操作
     * @param dto
     * @return
     */

    @Override
    public Result commit(CommitOrderDto dto) {
        Result result = Result.success(null);
        try{
            //查询库存
            SeckillGood seckillGood = (SeckillGood)redisTemplate.opsForHash().get(OrderConstant.GOOD_STOCK_REDIS_KEY, dto.getGoodId());
            if(seckillGood.getStock() <= 0){
                return Result.error(CodeMsg.MIAO_SHA_OVER);
            }else if(seckillGood.getStock() < dto.getCount()){
                dto.setCount(seckillGood.getStock());
                //保存订单，预留库存
                result.setMsg("余量不足，为您预定了【"+dto.getCount()+"】个商品");
                return result;
            }
            //更新redis数据
            seckillGood.setStock(seckillGood.getStock()-dto.getCount());
            BigDecimal price = seckillGood.getPrice();
            SeckillOrder seckillOrder = new SeckillOrder(dto.getUserId(),dto.getTargetAddr(),dto.getGoodId(),dto.getCount(),0,price.multiply(new BigDecimal(dto.getCount())), OrderStatusEnum.paying);
            try{
                redisTemplate.opsForHash().put(OrderConstant.GOOD_STOCK_REDIS_KEY,dto.getGoodId(), seckillGood);
            }catch (Exception e){
                log.error("redis 更新库存失败");
                rabbitTemplate.convertAndSend("directFailureQueue",JSON.toJSONString(seckillOrder));
            }
            rabbitTemplate.convertAndSend("directSuccessQueue", JSON.toJSONString(seckillOrder));
            log.info("预定成功【{}】，剩余【{}】",dto.getCount(), seckillGood.getStock());
        }catch (Exception e){
            log.error("error:" + e);
        }
        return result;
    }

    @Override
    public void readStockFromMysql() {
        List<SeckillGood> seckillGoods = goodMapper.getAllGoods();
        Map<Integer, SeckillGood> goodMap = new TreeMap<>();
        for(SeckillGood seckillGood : seckillGoods){
            goodMap.put(seckillGood.getId(), seckillGood);
        }
        redisTemplate.delete(OrderConstant.GOOD_STOCK_REDIS_KEY);
        redisTemplate.opsForHash().putAll(OrderConstant.GOOD_STOCK_REDIS_KEY,goodMap);
    }

    @RabbitListener(queues="directSuccessQueue")
    public void receiveOrderMsg(String msg){
        // TODO: 2020/3/25 分布式系统，新建订单系统，进行消息队列监听，保存订单信息
        ObjectMapper mapper = new ObjectMapper();
        try {
            SeckillOrder seckillOrder = mapper.readValue(msg, SeckillOrder.class);
            orderMapper.addOrder(seckillOrder);
            log.info("order 订单插入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues="directFailureQueue")
    public void receiveOrderFailureMsg(String msg){
        ObjectMapper mapper = new ObjectMapper();
        try {
            SeckillOrder seckillOrder = mapper.readValue(msg, SeckillOrder.class);
            orderMapper.handleFailureOrder(seckillOrder);
            log.info("处理失败订单");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
