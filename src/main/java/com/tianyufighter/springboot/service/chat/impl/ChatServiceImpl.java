package com.tianyufighter.springboot.service.chat.impl;

import com.tianyufighter.springboot.dao.ChatDao;
import com.tianyufighter.springboot.domain.Chat;
import com.tianyufighter.springboot.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理聊天消息的实现类
 */
@Service
public class ChatServiceImpl implements ChatService {
    /**
     * 处理聊天消息的dao
     */
    @Autowired
    private ChatDao chatDao;
    /**
     * 向数据库中存入一条聊天的消息
     * @param chat 聊天信息的实体类
     * @return 影响数据库的行数
     */
    @Override
    public int insertMessage(Chat chat) {
        return chatDao.insertChat(chat);
    }

    @Override
    public List<Chat> queryAllMessage(String username, String toUsername) {
        return chatDao.queryAllChat(username, toUsername);
    }

    @Override
    public List<Chat> queryChatByName(String toUsername) {
        return chatDao.queryChatByName(toUsername);
    }

    @Override
    public int updateIsComplete(String toUsername) {
        return chatDao.updateIsComplete(toUsername);
    }
}
