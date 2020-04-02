package com.yue.directrabbitmqsender.conf;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/2 12:02
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
        return new Queue("queue");
    }

    @Bean(name = "rabbitConnectionFactory")
    public ConnectionFactory connectionFactory(){
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
    public RabbitTemplate rabbitTemplate(@Qualifier("rabbitConnectionFactory") ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        return rabbitTemplate;
    }

    final RabbitTemplate.ConfirmCallback confirmCallback =  new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.out.println("correlationData: "+ correlationData);
            System.out.println("ack"+ack);
            if(!ack){
                System.out.println("异常处理");
//                String errorCase = correlationData.toString().split(":")[0];
//                switch (errorCase){
//                    case "order":
//                }
            }
        }
    };

    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            System.out.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        }
    };
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Bean(name = "myRabbitTemplate")
//    public RabbitTemplate rabbitTemplate() {
//        Logger log = LoggerFactory.getLogger(RabbitMqConfig.class);
//        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
//        rabbitTemplate.setMandatory(true);
//
//        // 消息返回, yml需要配置 publisher-returns: true
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//            String correlationId = message.getMessageProperties().getCorrelationId();
//            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
//        });
//
//        // 消息确认, yml需要配置 publisher-confirms: true
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (ack) {
//                // log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
//            } else {
//                log.debug("消息发送到exchange失败,原因: {}", cause);
//            }
//        });
//
//        return rabbitTemplate;
//    }
}

//@Configuration
//public class RabbitMqConfig {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        Logger log = LoggerFactory.getLogger(RabbitTemplate.class);
//        //未配置队列，如果设置false会导致消息丢失
//        rabbitTemplate.setMandatory(true);
//        //消息返回
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//            String correlationId = message.getMessageProperties().getCorrelationId();
//            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
//        });
//
//        //消息确认
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (ack) {
//                 log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
//            } else {
//                log.debug("消息发送到exchange失败,原因: {}", cause);
//            }
//        });
//        return rabbitTemplate;
//    }
//}
