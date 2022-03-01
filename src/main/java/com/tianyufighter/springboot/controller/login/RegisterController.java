package com.tianyufighter.springboot.controller.login;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.User;
import com.tianyufighter.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册
 */
//@RestController
//public class RegisterController {
//
//    @Autowired
//    public UserService userService;
//
//    @PostMapping("/register")
//    public CommonResult doRegister(@RequestParam("username") String username, @RequestParam("password") String password) {
//        System.out.println("新用户注册");
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        int res = userService.insertUser(user);
//        if(res == 1) {
//            return new CommonResult(200, "true");
//        } else {
//            return new CommonResult(444, "false");
//        }
//    }
//}
