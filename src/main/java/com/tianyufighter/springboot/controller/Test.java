package com.tianyufighter.springboot.controller;

import com.tianyufighter.springboot.domain.Chat;
import com.tianyufighter.springboot.service.card.CardService;
import com.tianyufighter.springboot.service.chat.ChatService;
import com.tianyufighter.springboot.service.comment.CommentService;
import com.tianyufighter.springboot.service.user.UserService;
import com.tianyufighter.springboot.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class Test {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ChatService chatService;
    @RequestMapping("/test")
    public void test01() {
        String res = userService.queryUserImage("zhangsan");
        System.out.println("res = " + res);
    }
}
