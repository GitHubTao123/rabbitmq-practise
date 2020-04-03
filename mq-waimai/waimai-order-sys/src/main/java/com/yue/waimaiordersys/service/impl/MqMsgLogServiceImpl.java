package com.yue.waimaiordersys.service.impl;

import com.yue.waimaiordersys.api.entity.MqMsgLog;
import com.yue.waimaiordersys.mapper.MqMsgLogMapper;
import com.yue.waimaiordersys.service.MqMsgLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 14:53
 */
@Service
public class MqMsgLogServiceImpl implements MqMsgLogService {

    @Autowired
    private MqMsgLogMapper mqMsgLogMapper;

    @Override
    public void updateStatus(int msgId, String status) {
        mqMsgLogMapper.updateStatusByMsgId(msgId,status);
    }

    @Override
    public MqMsgLog selectByMsgId(Integer msgId) {
        return mqMsgLogMapper.selectByPrimaryKey(msgId);
    }
}
