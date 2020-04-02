package com.yue.waimaiserver.service;

import com.yue.waimaiserver.api.entity.OrderMsg;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/2 17:52
 */
public interface HandleErrorService {

    boolean handleOrderError(Exchange exchange, Queue queue, OrderMsg orderMsg);
}
