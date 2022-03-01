package com.tianyufighter.springboot.controller.chat;

import com.tianyufighter.springboot.domain.Chat;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.chat.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class QueryAllChat {
    @Autowired
    private ChatService chatService;

    @RequestMapping("/queryAllMessage")
    public CommonResult<List<Chat>> queryAllMessage(HttpServletRequest request) {
        String username = request.getParameter("username");
        String toUsername = request.getParameter("toUsername");
        List<Chat> list = chatService.queryAllMessage(username, toUsername);
        if(list != null) {
            return new CommonResult<>(200, "数据查询成功", list);
        } else {
            return new CommonResult<>(444, "数据为查询成功");
        }
    }
}
