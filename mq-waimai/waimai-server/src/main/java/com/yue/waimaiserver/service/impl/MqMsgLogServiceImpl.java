package com.yue.waimaiserver.service.impl;

import com.yue.waimaiserver.api.entity.MqMsgLog;
import com.yue.waimaiserver.api.entity.MqMsgLogExample;
import com.yue.waimaiserver.common.CommonConstant;
import com.yue.waimaiserver.mapper.MqMsgLogMapper;
import com.yue.waimaiserver.service.MqMsgLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void insertMsg(MqMsgLog msgLog) {
        mqMsgLogMapper.insert(msgLog);
    }

    @Override
    public List<MqMsgLog> selectErrorMsg() {
        MqMsgLogExample example = new MqMsgLogExample();
        example.createCriteria().andStatusEqualTo(CommonConstant.MsgLogStatus.PRE_SEND);
        List<MqMsgLog> mqMsgLogs = mqMsgLogMapper.selectByExample(example);
        return mqMsgLogs;
    }

    @Override
    public void updateTryCount(int id, int tryCount) {
        mqMsgLogMapper.updateTryCount(id,tryCount);
    }

    @Override
    public void updateCause(int msgId, String cause) {
        mqMsgLogMapper.updateCause(msgId,cause);
    }

    @Override
    public void updateCauseAndStatus(int msgId, String cause,String status) {
        mqMsgLogMapper.updateCauseAndStatus(msgId,cause,status);
    }
}
