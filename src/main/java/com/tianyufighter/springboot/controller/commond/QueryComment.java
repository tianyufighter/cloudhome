package com.tianyufighter.springboot.controller.commond;

import com.tianyufighter.springboot.domain.Comment;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.card.CardService;
import com.tianyufighter.springboot.service.comment.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class QueryComment {
    @Autowired
    private CardService cardService;
    @Autowired
    private CommentService commentService;
    // 根据客户端发送的用户名和帖子标题查询与该帖子相关的评论
    @RequestMapping(value = "/selectComment", method = RequestMethod.POST)
    public CommonResult<List<Comment>> selectComment(HttpServletRequest request){
        System.out.println("收到客户端发送的评论请求");
        String username = request.getParameter("fusername");
        String title = request.getParameter("ftitle");
        // 查询帖子对应的id
        int tieZiId = cardService.queryId(username, title);
        List<Comment> list = commentService.queryCommentById(tieZiId);
        if(list == null) {
            return new CommonResult(444, "未在数据库中查询到响应的信息");
        } else {
            return new CommonResult(200, "数据查询成功", list);
        }
    }
}
