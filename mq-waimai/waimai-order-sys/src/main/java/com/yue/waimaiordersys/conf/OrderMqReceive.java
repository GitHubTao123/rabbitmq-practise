package com.yue.waimaiordersys.conf;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.yue.waimaiordersys.api.entity.MqMsgLog;
import com.yue.waimaiordersys.api.entity.WaimaiOrder;
import com.yue.waimaiordersys.common.CommonConstant;
import com.yue.waimaiordersys.service.MqMsgLogService;
import com.yue.waimaiordersys.service.WaimaiOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 11:28
 */
//@RabbitListener(bindings =
//    {@QueueBinding(
//        value = @Queue(value = "order-queue",durable = "true"),
//        exchange = @Exchange(value = "order-exchange",durable = "true"))
//    }
//)
@Component
public class OrderMqReceive {

    private Logger log = LoggerFactory.getLogger(OrderMqReceive.class);

    @Autowired
    private WaimaiOrderService waimaiOrderService;
    @Autowired
    private MqMsgLogService mqMsgLogService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order-queue",durable = "true"),
            exchange = @Exchange(value = "order-exchange",durable = "true")))
    public void onMessage(Message message, Channel channel) throws IOException, InterruptedException {
        WaimaiOrder order = JSONObject.parseObject(new String(message.getBody()),WaimaiOrder.class);
        int msgId = order.getMsgId();
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //判断接口幂等性（即是否重复消费）
        MqMsgLog msgLog = mqMsgLogService.selectByMsgId(msgId);
        if(msgLog == null){
            //msgLog为空，可能是msg还没来得及插入
            Thread.sleep(500);
            msgLog = mqMsgLogService.selectByMsgId(msgId);
        }
        if(msgLog == null || CommonConstant.MsgLogStatus.CONSUMED_SUCCESS.equals(msgLog.getStatus())){
            log.info("消息重复消费或消息为空，msgId: "+ msgId);
            return;
        }
        boolean result = waimaiOrderService.insert(order);
        if(result){
            channel.basicAck(deliveryTag,true);
            mqMsgLogService.updateStatus(msgId,CommonConstant.MsgLogStatus.CONSUMED_SUCCESS);
        }else{
            log.error("channel insert order error");
            channel.basicAck(deliveryTag,false);
            mqMsgLogService.updateStatus(msgId, CommonConstant.MsgLogStatus.CONSUMED_FAIL);
        }
    }
}
