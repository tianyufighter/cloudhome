package com.tianyufighter.springboot.controller.user;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 修改用户密码
 */
@RestController
@Slf4j
public class UpdatePassword {
    @Autowired
    private UserService userService;
    @RequestMapping("/updatePassword")
    public CommonResult updatePassword(HttpServletRequest request) {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String verifyCode = request.getParameter("verifyCode");
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        String s1 = (String) session.getAttribute("verCode");
        String s2 = verifyCode.toLowerCase();
        if(!s1.equals(s2)) {
            return new CommonResult(444, "false");
        }
        int res = userService.updatePasswordByName(username, oldPassword, newPassword);
        if(res == 0) {
            return new CommonResult(444, "false");
        } else {
            return new CommonResult(200, "true");
        }
    }
}
