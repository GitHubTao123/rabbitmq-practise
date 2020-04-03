//package com.yue.waimaiserver.service.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yue.waimaiserver.api.entity.MqMsgLog;
//import com.yue.waimaiserver.api.entity.WaimaiOrder;
//import com.yue.waimaiserver.service.HandleErrorService;
//import com.yue.waimaiserver.service.MqMsgLogService;
//import com.yue.waimaiserver.service.WaimaiOrderService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
///**
// * @Author: lsSaitaoYue
// * @Create: 2020/4/2 17:54
// */
//@Service
//public class HandleErrorServiceImpl implements HandleErrorService {
//
//    private Logger log = LoggerFactory.getLogger(HandleErrorServiceImpl.class);
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    private WaimaiOrderService waimaiOrderService;
//    @Autowired
//    private MqMsgLogService mqMsgLogService;
//
//    public boolean handleOrderError(String exchangeName, String queueName, long orderId) {
//        boolean result = Boolean.TRUE;
//        try{
//            long curTime = System.currentTimeMillis();
//            //1，重新提交订单到数据库（或更新内容）
//            WaimaiOrder waimaiOrder = waimaiOrderService.selectById(orderId);
//            waimaiOrder.setId(0);
//            waimaiOrder.setOrderTime(new Date(curTime));
//            waimaiOrderService.insert(waimaiOrder);
//            //2. 重新发送消息
//            CorrelationData correlationData = new CorrelationData("order:"+exchangeName+":"+queueName+":"+waimaiOrder.getId()+":"+curTime);
//            String orderJson = JSONObject.toJSONString(waimaiOrder);
//            rabbitTemplate.convertAndSend(exchangeName,queueName,orderJson,correlationData);
//        }catch (Exception e){
//            log.error("重新处理订单错误");
//            result = Boolean.FALSE;
//        }
//        return result;
//    }
//}
