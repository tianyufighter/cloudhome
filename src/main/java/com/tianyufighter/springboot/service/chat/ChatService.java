package com.tianyufighter.springboot.service.chat;

import com.tianyufighter.springboot.domain.Chat;

import java.util.List;

/**
 * 处理聊天的服务类
 */
public interface ChatService {
    /**
     * 向数据库存入一条聊天记录
     * @param chat 聊天信息的实体类
     * @return 影响数据库的行数
     */
    int insertMessage(Chat chat);

    /**
     * 根据双方的名字查询两者所有的聊天记录
     * @param username 发送者
     * @param toUsername 接收者
     * @return 返回查询的结果
     */
    List<Chat> queryAllMessage(String username, String toUsername);

    /**
     * 根据该用户名查看是否有该用户未接受的消息
     * @param toUsername
     * @return
     */
    List<Chat> queryChatByName(String toUsername);

    /**
     * 用户接收消息后，将字段isComplete设置为true
     * @param toUsername 接收者
     * @return 影响数据库的行数
     */
    int updateIsComplete(String toUsername);
}
