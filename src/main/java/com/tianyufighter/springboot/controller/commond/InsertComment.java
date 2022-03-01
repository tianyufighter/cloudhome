package com.tianyufighter.springboot.controller.commond;

import com.tianyufighter.springboot.domain.Comment;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.card.CardService;
import com.tianyufighter.springboot.service.comment.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@Slf4j
public class InsertComment {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CardService cardService;
    // 存储用户发表的评论
    @RequestMapping(value = "/storageInfo")
    public CommonResult<Comment> storageInfo(HttpServletRequest request) {
        // 获取请求的参数
        String username = request.getParameter("username");
        String content = request.getParameter("content");
        String fusername = request.getParameter("fusername");
        String ftitle = request.getParameter("ftitle");
        System.out.println("fusername = " + fusername);
        // 查找帖子的id
        int id = cardService.queryId(fusername, ftitle);
        Comment comment = new Comment();
        comment.setUsername(username);
        comment.setTieziId(id);
        comment.setCommentTime(new Date());
        comment.setContent(content);
        // 插入数据库中comment表中
        int res = commentService.insertComment(comment);
        if(res == 1) {
            return new CommonResult<Comment>(200, "true");
        } else {
            return new CommonResult<Comment>(444, "false");
        }
    }
}
