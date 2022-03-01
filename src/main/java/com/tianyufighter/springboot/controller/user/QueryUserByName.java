package com.tianyufighter.springboot.controller.user;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.User;
import com.tianyufighter.springboot.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 根据用户名查询用户的信息并返回前端
 */
@RestController
@Slf4j
public class QueryUserByName {
    @Autowired
    private UserService userService;
    @RequestMapping("queryUserInfoByName")
    public CommonResult<User> queryUserInfoByName(HttpServletRequest request) {
        String username = request.getParameter("username");
        User user = userService.queryUserInfoByName(username);
        if(user != null) {
            return new CommonResult<>(200, "数据请求成功", user);
        } else {
            return new CommonResult<>(444, "服务端系统故障");
        }
    }
}
