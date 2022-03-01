package com.tianyufighter.springboot.service.comment;

import com.tianyufighter.springboot.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CommentService {
    int insertComment(Comment comment);
    List<Comment> queryCommentById(int id);
}
