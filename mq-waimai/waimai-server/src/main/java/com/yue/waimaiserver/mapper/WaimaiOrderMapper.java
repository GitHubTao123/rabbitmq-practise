package com.yue.waimaiserver.mapper;

import java.util.List;

import com.yue.waimaiserver.api.entity.WaimaiOrder;
import com.yue.waimaiserver.api.entity.WaimaiOrderExample;
import org.apache.ibatis.annotations.Param;

public interface WaimaiOrderMapper {
    long countByExample(WaimaiOrderExample example);

    int deleteByExample(WaimaiOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaimaiOrder record);

    int insertSelective(WaimaiOrder record);

    List<WaimaiOrder> selectByExample(WaimaiOrderExample example);

    WaimaiOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaimaiOrder record, @Param("example") WaimaiOrderExample example);

    int updateByExample(@Param("record") WaimaiOrder record, @Param("example") WaimaiOrderExample example);

    int updateByPrimaryKeySelective(WaimaiOrder record);

    int updateByPrimaryKey(WaimaiOrder record);
}