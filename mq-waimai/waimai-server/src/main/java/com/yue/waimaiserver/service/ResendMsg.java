package com.yue.waimaiserver.service;

import com.yue.waimaiserver.api.entity.MqMsgLog;
import com.yue.waimaiserver.common.CommonConstant;
//import com.yue.waimaiserver.service.impl.HandleErrorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 14:57
 */
@Component
public class ResendMsg {

    private Logger log = LoggerFactory.getLogger(ResendMsg.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MqMsgLogService mqMsgLogService;

    //最大投递次数
    private static final int MAX_TRY_COUNT = 3;

    @Scheduled(cron = "0/30 * * * * * ?")
    public void resend(){
        log.info("开始执行任务，重新投递消息");

        List<MqMsgLog> msgLogs = mqMsgLogService.selectErrorMsg();
        for(MqMsgLog msgLog : msgLogs){
            //判断投递次数
            if(msgLog.getTryCount() > MAX_TRY_COUNT){
                log.error("超过最大重试次数,消息投递失败");
                mqMsgLogService.updateStatus(msgLog.getId(), CommonConstant.MsgLogStatus.SEND_FAIL);
            }else{
                log.info("开始重新投递消息");
                CorrelationData correlationData = new CorrelationData("order:"+msgLog.getId()+":"+System.currentTimeMillis());
                mqMsgLogService.updateTryCount(msgLog.getId(),msgLog.getTryCount()+1);
                rabbitTemplate.convertAndSend(CommonConstant.MqQueueAndExchange.ORDER_EXCHANGE,CommonConstant.MqQueueAndExchange.ORDER_EXCHANGE,
                        msgLog.getMsg(),correlationData);
                log.info("第 " + (msgLog.getTryCount() + 1) + " 次重新投递消息");
            }
        }
        log.info("定时任务执行结束(重新投递消息)");
    }
}
