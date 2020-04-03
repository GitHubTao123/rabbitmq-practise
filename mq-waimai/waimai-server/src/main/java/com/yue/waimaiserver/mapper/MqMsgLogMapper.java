package com.yue.waimaiserver.mapper;

import java.util.List;

import com.yue.waimaiserver.api.entity.MqMsgLog;
import com.yue.waimaiserver.api.entity.MqMsgLogExample;
import org.apache.ibatis.annotations.Param;

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

    void updateStatusByMsgId(@Param("msgId") int msgId,@Param("status") String status);

    void updateTryCount(@Param("id") int id,@Param("tryCount") int tryCount);

    void updateCause(@Param("id") int msgId,@Param("cause") String cause);

    void updateCauseAndStatus(@Param("id") int msgId,@Param("cause") String cause,@Param("status") String status);
}