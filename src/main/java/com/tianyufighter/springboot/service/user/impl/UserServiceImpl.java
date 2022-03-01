package com.tianyufighter.springboot.service.user.impl;

import com.tianyufighter.springboot.dao.UserDao;
import com.tianyufighter.springboot.domain.User;
import com.tianyufighter.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int insertUser(User user) {
        return userDao.insert(user);
    }

    // 查询数据库中是否有该用户
    @Override
    public User queryUser(String username, String password) {
        return userDao.queryUser(username, password);
    }

    @Override
    public int updateSelfInfo(User user) {
        return userDao.updateSelfInfo(user);
    }

    @Override
    public User queryUserInfoByName(String username) {
        return userDao.queryUserInfoByName(username);
    }

    @Override
    public int updatePasswordByName(String username, String oldPassword, String newPassword) {
        return userDao.updatePasswordByName(username, oldPassword, newPassword);
    }

    @Override
    public String queryUserImage(String username) {
        return userDao.queryHeadImageByName(username);
    }
}
