package com.yue.waimaiordersys.mapper;

import com.yue.waimaiordersys.api.entity.SalerGoods;
import com.yue.waimaiordersys.api.entity.SalerGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalerGoodsMapper {
    long countByExample(SalerGoodsExample example);

    int deleteByExample(SalerGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalerGoods record);

    int insertSelective(SalerGoods record);

    List<SalerGoods> selectByExample(SalerGoodsExample example);

    SalerGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalerGoods record, @Param("example") SalerGoodsExample example);

    int updateByExample(@Param("record") SalerGoods record, @Param("example") SalerGoodsExample example);

    int updateByPrimaryKeySelective(SalerGoods record);

    int updateByPrimaryKey(SalerGoods record);
}