package com.tianyufighter.springboot.service.user;

import com.tianyufighter.springboot.domain.User;

public interface UserService {

    int insertUser(User user);

    User queryUser(String username, String password);

    // 根据用户名修改个人信息
    int updateSelfInfo(User user);
    // 根据用户名查询个人信息
    User queryUserInfoByName(String username);
    // 根据用户名修改用户密码
    int updatePasswordByName(String username, String oldPassword, String newPassword);
    // 根据用户名查找用户头像的路径
    String queryUserImage(String username);
}
