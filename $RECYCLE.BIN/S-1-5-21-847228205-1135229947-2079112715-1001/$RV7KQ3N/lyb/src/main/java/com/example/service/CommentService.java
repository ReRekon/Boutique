package com.example.service;

import com.example.entity.Comment;
import com.example.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public Comment find(int id)
    {

        return commentMapper.find(id);
    }

    public void add(Comment comment)
    {

        commentMapper.add(comment);
    }

    public void delete(int id)
    {

        commentMapper.delete(id);
    }

    //返回所有评论
    public List<Comment> findAll()
    {
        return commentMapper.findAll();
    }
}
