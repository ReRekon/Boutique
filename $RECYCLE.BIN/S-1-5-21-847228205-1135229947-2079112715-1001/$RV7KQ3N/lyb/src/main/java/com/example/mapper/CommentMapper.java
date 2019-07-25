package com.example.mapper;

import com.example.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    //查
    Comment find(int id);
    //增
    void add(Comment comment);
    //删
    void delete(int id);
    //查找
    List<Comment> findAll();
    //根据用户ID和商品ID查找评论
    List<Comment> findById(int uerId,int articleId);
    //查找该评论所有的子评论
    List<Comment> findChild(int commentId);
}
