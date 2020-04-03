package com.yue.waimaiserver.controller;

import com.yue.waimaiserver.service.WaimaiOrderService;
import com.yue.waimaiserver.api.params.queryParams.WaimaiOrderParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 11:46
 */
@RestController
@RequestMapping("/order")
public class OrderContoller {

    @Autowired
    private WaimaiOrderService waimaiOrderService;

    @PostMapping("/insertOrder")
    public void insertOrder(@RequestBody WaimaiOrderParams orderParams){
        waimaiOrderService.insert(orderParams);
    }
}
