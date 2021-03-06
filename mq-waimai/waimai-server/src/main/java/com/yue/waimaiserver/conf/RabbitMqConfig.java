package com.yue.waimaiserver.conf;

import com.alibaba.fastjson.JSONObject;
import com.yue.waimaiserver.api.entity.WaimaiOrder;
import com.yue.waimaiserver.common.CommonConstant;
import com.yue.waimaiserver.service.MqMsgLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/2 12:02
 */
@Configuration
public class RabbitMqConfig {

    private Logger log = LoggerFactory.getLogger(RabbitMqConfig.class);

    @Autowired
    private MqMsgLogService mqMsgLogService;

    @Bean(name = "rabbitConnectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        //进行判断生产环境、测试环境
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setPublisherReturns(true);
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(@Qualifier("rabbitConnectionFactory") ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        return rabbitTemplate;
    }

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            String correlationDataId = correlationData.getId();
            int msgId = Integer.parseInt(correlationDataId.split(":")[1]);
            if (!ack) {
                log.info("消息发送到Exchange失败，{}，cause：{}",correlationData,cause);
                mqMsgLogService.updateCause(msgId,cause);
            }else{
                mqMsgLogService.updateCauseAndStatus(msgId, null,CommonConstant.MsgLogStatus.SEND_SUCCESS);
            }
        }
    };

    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            WaimaiOrder waimaiOrder = JSONObject.parseObject(new String(message.getBody()), WaimaiOrder.class);
            log.error("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
            mqMsgLogService.updateCauseAndStatus(waimaiOrder.getMsgId(),replyText,CommonConstant.MsgLogStatus.PRE_SEND);
        }
    };
}