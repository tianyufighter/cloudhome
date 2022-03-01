package com.tianyufighter.springboot.controller.chat;

import com.tianyufighter.springboot.domain.Chat;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.chat.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class QueryChatByName {
    @Autowired
    private ChatService chatService;

    @Transactional
    @RequestMapping("/queryMessageByName")
    public CommonResult<List<Chat>> queryMessageByName(HttpServletRequest request) {
        String toUsername = request.getParameter("toUsername");
        List<Chat> lists = chatService.queryChatByName(toUsername);
        int res = chatService.updateIsComplete(toUsername);
        if(lists != null && res != 0) {
            return new CommonResult<>(200, "好友发消息了", lists);
        } else {
            return new CommonResult<>(444, "没有消息");
        }
    }
}
