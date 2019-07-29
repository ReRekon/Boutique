package com.example.mapper;

import com.example.entity.Comment;
import com.example.vo.CommentList;
import com.example.entity.CommentReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentMapper {

    //增加评论----->只能通过订单号来写评论   ---->返回1代表评论成功
    int addComment(@Param("orderId") int orderId, @Param("date")Date date,
                   @Param("commentContent")String commentContent,
                   @Param("pic") String pic, @Param("star")int star);

    //增加追加评论    state：0--->未追评      state：1--->已追评
    int addReply(@Param("orderId")int orderId, @Param("connect")String connect,@Param("date") Date date);

    //追评改变评论表state为1
    int updateReply(@Param("orderId")int orderId);

   //显示商品的所有评论
    List<CommentList> findAllCommentByArticle(@Param("articleId")int articleId);

    //查询追加评论
    List<CommentReply> findChild(@Param("commentId")int commentId);

    //显示用户的所有评论
    List<CommentList> findAllCommentByUser(@Param("userId")int userId);

    //显示个人评论总数
    int findCount(@Param("userId")int userId);

    //根据商品获取商品评分
    List<Comment> getStar(@Param("articleId")int articleId);
}
