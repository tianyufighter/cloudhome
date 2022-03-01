package com.tianyufighter.springboot.service.lostgood;

import com.tianyufighter.springboot.domain.Lostgood;

import java.util.List;

public interface LostgoodService {
    // 向数据库中插入一条失物招领信息
    int insertOneLostgood(Lostgood lostgood);
    // 根据变量num查询数据中指定位置，指定条数的信息
    List<Lostgood> queryLostgood(int num);
}
