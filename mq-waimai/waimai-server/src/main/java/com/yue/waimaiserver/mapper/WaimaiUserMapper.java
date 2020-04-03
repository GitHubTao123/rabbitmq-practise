package com.yue.waimaiserver.mapper;

import java.util.List;

import com.yue.waimaiserver.api.entity.WaimaiUser;
import com.yue.waimaiserver.api.entity.WaimaiUserExample;
import org.apache.ibatis.annotations.Param;

public interface WaimaiUserMapper {
    long countByExample(WaimaiUserExample example);

    int deleteByExample(WaimaiUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaimaiUser record);

    int insertSelective(WaimaiUser record);

    List<WaimaiUser> selectByExample(WaimaiUserExample example);

    WaimaiUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaimaiUser record, @Param("example") WaimaiUserExample example);

    int updateByExample(@Param("record") WaimaiUser record, @Param("example") WaimaiUserExample example);

    int updateByPrimaryKeySelective(WaimaiUser record);

    int updateByPrimaryKey(WaimaiUser record);
}