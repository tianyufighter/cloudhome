package com.tianyufighter.springboot.controller.contactperson;

import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Contactperson;
import com.tianyufighter.springboot.service.contactperson.ContactpersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class QueryFriend {
    @Autowired
    private ContactpersonService contactpersonService;

    @RequestMapping("/queryFriend")
    public CommonResult<List<Contactperson>> queryFriend(HttpServletRequest request) {
        String username = request.getParameter("username");
        List<Contactperson> lists = contactpersonService.queryPerson(username);
        if(lists != null) {
            return new CommonResult<>(200, "数据查询成功", lists);
        } else {
            return new CommonResult<>(444, "数据查询失败");
        }
    }
}
