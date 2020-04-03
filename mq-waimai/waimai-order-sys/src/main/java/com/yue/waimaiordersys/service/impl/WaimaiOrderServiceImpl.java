package com.yue.waimaiordersys.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yue.waimaiordersys.api.entity.WaimaiOrder;
import com.yue.waimaiordersys.api.entity.WaimaiOrderExample;
import com.yue.waimaiordersys.mapper.WaimaiOrderMapper;
import com.yue.waimaiordersys.service.WaimaiOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 10:29
 */
@Service
public class WaimaiOrderServiceImpl implements WaimaiOrderService {

    @Autowired
    private WaimaiOrderMapper waimaiOrderMapper;

    @Override
    public WaimaiOrder selectById(long orderId) {
        return waimaiOrderMapper.selectByPrimaryKey(new Long(orderId).intValue());
    }

    @Override
    public boolean insert(WaimaiOrder waimaiOrder) {
        return waimaiOrderMapper.insert(waimaiOrder)==0? Boolean.FALSE: Boolean.TRUE;
    }

    @Override
    public List<WaimaiOrder> getOrderByConsumerId(int userId) {
        WaimaiOrderExample example = new WaimaiOrderExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<WaimaiOrder> waimaiOrders = waimaiOrderMapper.selectByExample(example);
        return waimaiOrders;
    }
}
