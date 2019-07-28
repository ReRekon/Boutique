package com.example.service;

import com.example.entity.CommentList;
import com.example.entity.CommentReply;

import java.util.List;

public interface CommentService {

    //增加评论----->只能通过订单号来写评论
    int addComment(int orderId,String commentContent, String pic,int star);

    //增加追加评论    state:0--->未评论  state:1--->未追评  state:2--->不能评论
    int addReply(int orderId,String connect);

    //显示商品所有评论
    List<CommentList> findAllCommentByArticle(int articleId);

    //查询追加评论
    List<CommentReply> findChild(int commentId);

    ////显示用户的所有评论
    List<CommentList> findAllCommentByUser(int userId);

    //显示个人评论总数
    int findCount(int userId);

    //根据商品获取商品评分
    String getStar(int articleId);

}
