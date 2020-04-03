package com.yue.waimaiordersys.mapper;

import java.util.List;

import com.yue.waimaiordersys.api.entity.WaimaiSaler;
import com.yue.waimaiordersys.api.entity.WaimaiSalerExample;
import org.apache.ibatis.annotations.Param;

public interface WaimaiSalerMapper {
    long countByExample(WaimaiSalerExample example);

    int deleteByExample(WaimaiSalerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaimaiSaler record);

    int insertSelective(WaimaiSaler record);

    List<WaimaiSaler> selectByExample(WaimaiSalerExample example);

    WaimaiSaler selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaimaiSaler record, @Param("example") WaimaiSalerExample example);

    int updateByExample(@Param("record") WaimaiSaler record, @Param("example") WaimaiSalerExample example);

    int updateByPrimaryKeySelective(WaimaiSaler record);

    int updateByPrimaryKey(WaimaiSaler record);
}