package com.tianyufighter.springboot.controller.contactperson;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.contactperson.ContactpersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class DeletePerson {
    @Autowired
    private ContactpersonService contactpersonService;

    @RequestMapping("/deleteLiaison")
    public CommonResult deleteLiaison(HttpServletRequest request) {
        String username = request.getParameter("username");
        String toUsername = request.getParameter("toUsername");
        int res = contactpersonService.deleteLiaison(username, toUsername);
        if(res == 1) {
            return new CommonResult(200, "删除成功");
        } else {
            return new CommonResult(444, "删除失败");
        }
    }
}
