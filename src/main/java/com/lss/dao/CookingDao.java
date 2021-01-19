package com.lss.dao;

import com.lss.pojo.entity.Cooking;
import com.lss.pojo.entity.CookingKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CookingDao {
    int deleteByPrimaryKey(CookingKey key);

    int insert(Cooking record);

    int insertSelective(Cooking record);

    Cooking selectByPrimaryKey(CookingKey key);

    int updateByPrimaryKeySelective(Cooking record);

    int updateByPrimaryKey(Cooking record);
}