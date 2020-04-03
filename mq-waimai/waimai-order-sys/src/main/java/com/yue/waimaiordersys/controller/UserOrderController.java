package com.yue.waimaiordersys.controller;

import com.yue.waimaiordersys.api.entity.WaimaiOrder;
import com.yue.waimaiordersys.service.WaimaiOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 11:14
 */
@RequestMapping("/consumerOrder")
@RestController
public class UserOrderController {

    @Autowired
    private WaimaiOrderService waimaiOrderService;

    @GetMapping("/getOrderByConsumerId")
    public List<WaimaiOrder> getOrderByConsumerId(@RequestParam @NotNull int userId){
        return waimaiOrderService.getOrderByConsumerId(userId);
    }
}
