package com.yue.waimaiordersys.mapper;

import com.yue.waimaiordersys.api.entity.MqMsgLog;
import com.yue.waimaiordersys.api.entity.MqMsgLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MqMsgLogMapper {
    long countByExample(MqMsgLogExample example);

    int deleteByExample(MqMsgLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MqMsgLog record);

    int insertSelective(MqMsgLog record);

    List<MqMsgLog> selectByExample(MqMsgLogExample example);

    MqMsgLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MqMsgLog record, @Param("example") MqMsgLogExample example);

    int updateByExample(@Param("record") MqMsgLog record, @Param("example") MqMsgLogExample example);

    int updateByPrimaryKeySelective(MqMsgLog record);

    int updateByPrimaryKey(MqMsgLog record);

    void updateStatusByMsgId(@Param("msgId") int msgId, @Param("status") String status);
}