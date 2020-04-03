package com.yue.waimaiordersys.conf;

import com.yue.waimaiordersys.service.HandleErrorService;
import org.springframework.amqp.core.*;
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

    @Autowired
    private HandleErrorService handleErrorService;

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
        rabbitTemplate.containerAckMode(AcknowledgeMode.MANUAL);
        return rabbitTemplate;
    }

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.out.println("correlationData: " + correlationData);
            System.out.println("ack" + ack);
            if (!ack) {
                System.out.println("异常处理");
                String[] split = correlationData.toString().split(":");
                String errorCase = split[0];
                String exchangeName = split[1];
                String queueName = split[2];
                long orderId = Long.valueOf(split[3]);
                switch (errorCase) {
                    case "error-handle-queue":
                        handleErrorService.handleOrderNotReach(exchangeName,queueName,String.valueOf(orderId));
                        break;
                }
            }
        }
    };

    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            System.out.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
            switch (exchange) {
                case "error-handle-exchange":
                    handleErrorService.handleOrderNotReach(exchange,routingKey,new String(message.getBody()));
                    break;
            }
        }
    };

    @Bean
    public Queue orderQueue(){
        return new Queue("error-handle-queue");
    }

    @Bean
    public Exchange orderExchange(){
        return ExchangeBuilder.directExchange("error-handle-exchange").build();
    }
}