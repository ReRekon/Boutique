package com.example.mapper;

import com.example.entity.Comment;
import com.example.entity.CommentList;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentMapper {


    //查找该评论所有的子评论
    List<Comment> findChild(int commentId);

    //增加评论------>只能通过订单来写评论
    void addCommentByOrder(int orderId, Date date,String commentContent,String pic);

    //显示评论列表------>三表查询    根据商品编号查询该商品的所有评论
    List<CommentList> findAllComment(int articleId);

    //显示用户个人的评论列表，
    List<CommentList> findById(int userId);

    //显示个人评论总数
    int findCount(int userId);
}
