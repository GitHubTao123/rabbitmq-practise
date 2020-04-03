package com.yue.waimaiserver.common;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 11:49
 */
public interface CommonConstant {

    class MqQueueAndExchange{

        public static final String ORDER_QUEUE = "order-queue";

        public static final String ORDER_EXCHANGE = "order-exchange";
    }

    class MsgLogStatus{
        public static final String CONSUMED_FAIL = "consumed_fail";
        public static final String CONSUMED_SUCCESS = "consumed_success";
        public static final String PRE_SEND = "pre_send";
        public static final String  SEND_SUCCESS = "send_success";
        public static final String  SEND_FAIL = "send_fail";
    }
}
