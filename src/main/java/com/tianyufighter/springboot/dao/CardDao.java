package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CardDao {
    // 将用户帖子存储进数据库
    int insertCard(Card card);
    // 查询用户的帖子
    List<Card> query(@Param("num") int num);
    // 根据用户名和帖子标题查找帖子的ID
    Integer queryId(@Param("username") String username, @Param("title") String title);
}
