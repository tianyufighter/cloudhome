package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    int insert(User user);
    // 根据用户名和密码查询用户是否存在
    User queryUser(@Param("username") String username, @Param("password")String password);
    // 根据用户名更改个人信息
    int updateSelfInfo(User user);
    // 根据用户名查询用户信息
    User queryUserInfoByName(@Param("username") String username);
    // 用户根据用户名修改密码
    int updatePasswordByName(@Param("username") String username, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);
    // 根据用户名查找头像路径
    String queryHeadImageByName(@Param("username") String username);
}
