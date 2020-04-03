package com.yue.waimaiserver.service;

import com.yue.waimaiserver.api.entity.MqMsgLog;

import java.util.List;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 14:52
 */
public interface MqMsgLogService {
    void updateStatus(int msgId, String status);

    void insertMsg(MqMsgLog msgLog);

    List<MqMsgLog> selectErrorMsg();

    void updateTryCount(int id, int i);

    void updateCause(int msgId, String cause);

    void updateCauseAndStatus(int msgId, String cause,String status);
}
