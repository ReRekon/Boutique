package com.example.mapper;

import com.example.entity.Comment;
import com.example.entity.CommentReply;
import com.example.vo.CommentList;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentMapper {

    //增加评论----->只能通过订单号来写评论   ---->返回1代表评论成功
    int addComment(int orderId, Date date, String commentContent, String pic, int star);

    //增加追加评论    state：0--->未追评      state：1--->已追评
    int addReply(int orderId, String connect, Date date);

    //追评改变评论表state为1
    int updateReply(int orderId);

   //显示商品的所有评论
    List<CommentList> findAllCommentByArticle(int articleId);

    //查询追加评论
    List<CommentReply> findChild(int commentId);

    //显示用户的所有评论
    List<CommentList> findAllCommentByUser(int userId);

    //显示个人评论总数
    int findCount(int userId);

    //根据商品获取商品评分
    List<Comment> getStar(int articleId);
}
