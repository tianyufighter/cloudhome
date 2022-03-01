package com.tianyufighter.springboot.controller.login;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.User;
import com.tianyufighter.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证用户输入的用户名和密码是否正确
 */
@RestController
public class LoginController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public CommonResult<User> doLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.queryUser(username, password);
        if(user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            Cookie cookie = new Cookie("username", user.getUsername());
            System.out.println("username: " + user.getUsername());
            cookie.setPath("/");//路径，访问地址带“/”时携带cookie信息
            response.addCookie(cookie);
            Cookie cookie1 = new Cookie("headImage", user.getHeadImage());
//            usernameCookie.setHttpOnly(true);
//            usernameCookie.setMaxAge(60*60*24*365);
//            cookie.setDomain("");//作用域
//            cookie1.setDomain("localhost");//作用域
            cookie1.setPath("/");//路径，访问地址带“/”时携带cookie信息
            response.addCookie(cookie1);
            return new CommonResult(200, "true", user);
        } else {
            return new CommonResult(444, "false", user);
        }
    }
}
