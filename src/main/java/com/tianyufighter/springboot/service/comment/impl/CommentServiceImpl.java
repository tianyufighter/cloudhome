package com.tianyufighter.springboot.service.comment.impl;

import com.tianyufighter.springboot.dao.CommentDao;
import com.tianyufighter.springboot.domain.Comment;
import com.tianyufighter.springboot.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public int insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public List<Comment> queryCommentById(int id) {
        return commentDao.queryCommentById(id);
    }
}
