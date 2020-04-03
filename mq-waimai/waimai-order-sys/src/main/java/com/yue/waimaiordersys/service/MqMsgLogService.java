package com.yue.waimaiordersys.service;

import com.yue.waimaiordersys.api.entity.MqMsgLog;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 14:52
 */
public interface MqMsgLogService {
    void updateStatus(int msgId, String status);

    MqMsgLog selectByMsgId(Integer msgId);
}
