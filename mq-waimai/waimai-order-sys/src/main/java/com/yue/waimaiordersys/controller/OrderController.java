package com.yue.waimaiordersys.controller;

import com.yue.waimaiordersys.api.entity.WaimaiOrder;
import com.yue.waimaiordersys.service.WaimaiOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 11:10
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private WaimaiOrderService waimaiOrderService;

    @GetMapping("/getOrderById")
    public WaimaiOrder getOrderById(@RequestParam @NotNull int orderId){
        return waimaiOrderService.selectById(orderId);
    }
}
