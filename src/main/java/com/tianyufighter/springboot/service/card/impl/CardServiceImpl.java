package com.tianyufighter.springboot.service.card.impl;

import com.tianyufighter.springboot.dao.CardDao;
import com.tianyufighter.springboot.domain.Card;
import com.tianyufighter.springboot.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardDao cardDao;
    @Override
    public int insertCard(Card card) {
        return cardDao.insertCard(card);
    }

    @Override
    public List<Card> queryCardByNum(int num) {
        return cardDao.query(num);
    }

    @Override
    public Integer queryId(String username, String title) {
        return cardDao.queryId(username, title);
    }
}
