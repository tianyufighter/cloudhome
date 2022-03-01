package com.tianyufighter.springboot.service.card;

import com.tianyufighter.springboot.domain.Card;

import java.util.List;

public interface CardService {
    int insertCard(Card card);
    // 根据要传入的数据的起始点来查询数据，默认每次查询四条数据
    List<Card> queryCardByNum(int num);
    // 根据用户名和帖子标题查询帖子的id
    Integer queryId(String username, String title);
}
