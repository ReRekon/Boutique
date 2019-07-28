package com.example.service;

import com.example.entity.Comment;
import com.example.entity.CommentList;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CommentServiceInterface {
    //查询该评论的所有子评论
    public List<Comment> findChild(int commentId);

    //增加评论------>只能通过订单来写评论
    public void addCommentByOrder(int orderId, String commentContent, Date date,String pic);

    //查找评论列表---------->三表查询某件商品的所有评论
    public List<CommentList> findAllComment(int articleId);

    //查找个人的所有评论
    public List<CommentList> findById(int userId);

    //显示个人评论总数
    public int findCount(int userId);
}
