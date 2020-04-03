package com.yue.waimaiserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yue.waimaiserver.api.entity.MqMsgLog;
import com.yue.waimaiserver.api.entity.WaimaiOrder;
import com.yue.waimaiserver.common.CommonConstant;
import com.yue.waimaiserver.mapper.WaimaiOrderMapper;
import com.yue.waimaiserver.service.MqMsgLogService;
import com.yue.waimaiserver.service.WaimaiOrderService;
import com.yue.waimaiserver.api.params.queryParams.WaimaiOrderParams;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 10:29
 */
@Service
public class WaimaiOrderServiceImpl implements WaimaiOrderService {

    @Autowired
    private WaimaiOrderMapper waimaiOrderMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MqMsgLogService mqMsgLogService;

    @Override
    public WaimaiOrder selectById(long orderId) {
        return waimaiOrderMapper.selectByPrimaryKey(new Long(orderId).intValue());
    }

    @Override
    public void insert(WaimaiOrderParams orderParams) {
        WaimaiOrder waimaiOrder = new WaimaiOrder(0,orderParams.getUserId(),orderParams.getSalerId(),orderParams.getGoodId(),orderParams.getOrderTime(),orderParams.getTotalPrice(),0);
        String exchangeName = CommonConstant.MqQueueAndExchange.ORDER_EXCHANGE;
        String queueName = CommonConstant.MqQueueAndExchange.ORDER_QUEUE;
        String orderJson = JSONObject.toJSONString(waimaiOrder);
        //消息入库
        MqMsgLog msgLog = new MqMsgLog(0,CommonConstant.MsgLogStatus.PRE_SEND,null,exchangeName,queueName,orderJson,(byte)(0xff & 0));
        mqMsgLogService.insertMsg(msgLog);
        waimaiOrder.setMsgId(msgLog.getId());
        String orderJson2 = JSONObject.toJSONString(waimaiOrder);
        CorrelationData correlationData = new CorrelationData("order:"+msgLog.getId()+":"+System.currentTimeMillis());
        rabbitTemplate.convertAndSend(exchangeName,queueName,orderJson2,correlationData);
    }
}
