package com.example.serviceImpl;

import com.example.entity.Comment;
import com.example.entity.CommentList;
import com.example.mapper.CommentMapper;
import com.example.service.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentService implements CommentServiceInterface {
    @Autowired
    private CommentMapper commentMapper;

    //查询该评论的所有子评论
    @Override
    public List<Comment> findChild(int commentId)
    {
        return commentMapper.findChild(commentId);
    }

    //增加评论------>只能通过订单来写评论
    @Override
    public void addCommentByOrder(int orderId, String commentContent, Date date,String pic){
        commentMapper.addCommentByOrder(orderId,date,commentContent,pic);
    }

    //查找评论列表---------->三表查询某件商品的所有评论
    @Override
    public List<CommentList> findAllComment(int articleId)
    {
        return commentMapper.findAllComment(articleId);
    }

    //查找个人的所有评论
    @Override
    public List<CommentList> findById(int userId)
    {
        return commentMapper.findById(userId);
    }

    @Override
    public int findCount(int userId) {
        return commentMapper.findCount(userId);
    }
}
