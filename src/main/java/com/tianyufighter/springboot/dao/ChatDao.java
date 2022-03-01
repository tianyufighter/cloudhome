package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.Chat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChatDao {
    // 向数据库中存储聊天记录
    int insertChat(Chat chat);
    // 根据双方的名字查询所有的聊天记录
    List<Chat> queryAllChat(@Param("username") String username, @Param("toUsername") String toUsername);

    // 用户用户名查询是否有该用户的聊天消息，如果有就将该用户为接收的消息全部返回给客户端
    List<Chat> queryChatByName(@Param("toUsername") String toUsername);

    // 当用户接收到消息后，将字段is_complete设置为ture标记完成
    int updateIsComplete(@Param("toUsername") String toUsername);
}
