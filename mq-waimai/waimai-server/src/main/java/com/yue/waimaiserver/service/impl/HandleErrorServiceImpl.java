package com.yue.waimaiserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yue.waimaiserver.api.entity.OrderMsg;
import com.yue.waimaiserver.service.HandleErrorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/2 17:54
 */
@Service
public class HandleErrorServiceImpl implements HandleErrorService {

    private Logger log = LoggerFactory.getLogger(HandleErrorServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean handleOrderError(Exchange exchange, Queue queue, OrderMsg orderMsg) {
        boolean result = Boolean.TRUE;
        try{
            //1，重新提交订单到数据库（或更新内容）

            //2. 重新发送消息
            CorrelationData correlationData = new CorrelationData("order:"+System.currentTimeMillis());
            String orderJson = JSONObject.toJSONString(orderMsg);
            rabbitTemplate.convertAndSend(exchange.getName(),queue.getName(),orderJson,correlationData);
        }catch (Exception e){
            log.error("重新处理订单错误");
            result = Boolean.FALSE;
        }
        return result;
    }
}
