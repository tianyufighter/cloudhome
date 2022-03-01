package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.Lostgood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LostgoodDao {
    // 向数据库中加入一条失物招领信息
    int insertOneLostgood(Lostgood lostgood);
    // 根据变量num查询事务招领信息
    List<Lostgood> queryLostgood(@Param("num") int num);
}
