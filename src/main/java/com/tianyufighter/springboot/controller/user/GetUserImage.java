package com.tianyufighter.springboot.controller.user;

import checkers.util.report.quals.ReportUse;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 根据用户名查找用户的头像
 */
@RestController
@Slf4j
public class GetUserImage {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUserImage")
    public CommonResult<String> getUserImage(HttpServletRequest request) {
        String username = request.getParameter("username");
        String s = userService.queryUserImage(username);
        return new CommonResult<>(200, "数据请求成功", s);
    }
}
