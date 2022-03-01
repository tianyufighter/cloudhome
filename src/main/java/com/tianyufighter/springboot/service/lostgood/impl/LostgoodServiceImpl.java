package com.tianyufighter.springboot.service.lostgood.impl;

import com.tianyufighter.springboot.dao.LostgoodDao;
import com.tianyufighter.springboot.domain.Lostgood;
import com.tianyufighter.springboot.service.lostgood.LostgoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LostgoodServiceImpl implements LostgoodService {
    @Autowired
    private LostgoodDao lostgoodDao;

    @Override
    public int insertOneLostgood(Lostgood lostgood) {
        return lostgoodDao.insertOneLostgood(lostgood);
    }

    @Override
    public List<Lostgood> queryLostgood(int num) {
        return lostgoodDao.queryLostgood(num);
    }
}
