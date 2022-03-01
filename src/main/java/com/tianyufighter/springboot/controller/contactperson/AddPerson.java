package com.tianyufighter.springboot.controller.contactperson;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Contactperson;
import com.tianyufighter.springboot.service.contactperson.ContactpersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class AddPerson {
    @Autowired
    private ContactpersonService contactpersonService;
    @RequestMapping("/addPerson")
    public CommonResult addPerson(HttpServletRequest request) {
        String master = request.getParameter("master");
        String friend = request.getParameter("friend");
        String friendImage = request.getParameter("friendImage");
        // 查询数据库中是否已经有了此对联系人
        Contactperson contactperson1 = contactpersonService.isContactPerson(master, friend);
        if(contactperson1 != null) {
            return new CommonResult(333, "数据库已有此对联系人");
        }
        Contactperson contactperson = new Contactperson();
        contactperson.setMaster(master);
        contactperson.setFriend(friend);
        contactperson.setFriendImage(friendImage);
        int res = contactpersonService.insertPerson(contactperson);
        if(res == 1) {
            return new CommonResult(200, "数据存储成功");
        } else {
            return new CommonResult(444, "数据存储失败");
        }
    }
}
