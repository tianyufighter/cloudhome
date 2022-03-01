package com.tianyufighter.springboot.dao;

import com.tianyufighter.springboot.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {
    // 插入评论
    int insertComment(Comment comment);
    // 查询评论
    List<Comment> queryCommentById(@Param("id") int id);
}
