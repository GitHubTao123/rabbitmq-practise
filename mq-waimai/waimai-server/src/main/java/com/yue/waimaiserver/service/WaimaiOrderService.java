package com.yue.waimaiserver.service;

import com.yue.waimaiserver.api.entity.WaimaiOrder;
import com.yue.waimaiserver.api.params.queryParams.WaimaiOrderParams;
//import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 10:28
 */
//@FeignClient
public interface WaimaiOrderService {
    WaimaiOrder selectById(long orderId);

    void insert(WaimaiOrderParams orderParams);
}
