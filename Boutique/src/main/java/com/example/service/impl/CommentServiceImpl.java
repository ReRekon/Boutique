package com.example.service.impl;

import com.example.entity.Comment;
import com.example.vo.CommentList;
import com.example.entity.CommentReply;
import com.example.mapper.CommentMapper;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    //增加评论----->只能通过订单号来写评论
    @Override
    public int addComment(int orderId,String commentContent, String pic,int star) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return commentMapper.addComment(orderId,date,commentContent,pic,star);
    }

    //增加追加评论    state:0--->未评论  state:1--->已追评
    @Transactional
    @Override
    public int addReply(int orderId,String connect) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        //追加评论之后评论的state改为1
        int add=commentMapper.addReply(orderId,connect,date);
        int update=commentMapper.updateReply(orderId);
        if(update==1&&add==1)
            return 1;
        else {
            throw new RuntimeException("错误");
        }
    }

    //先显示商品所有评论
    @Override
    public List<CommentList> findAllCommentByArticle(int articleId) {
        List<CommentList> list=commentMapper.findAllCommentByArticle(articleId);
        for(CommentList commentList:list){
            if(commentList.getState()==1){
                int commentId=commentList.getCommentId();
                List<CommentReply> listReply=commentMapper.findChild(commentId);
                for (CommentReply commentReply:listReply){
                    commentList.setReplyConnent(commentReply.getReplyConnect());
                    commentList.setReplyTime(commentReply.getReplyTime());
                }
            }
        }
        return list;
    }

    //查询追加评论
    @Override
    public List<CommentReply> findChild(int commentId) {
        return commentMapper.findChild(commentId);
    }

    //显示用户的所有评论
    @Override
    public List<CommentList> findAllCommentByUser(int userId) {
        List<CommentList> list=commentMapper.findAllCommentByUser(userId);
        for(CommentList commentList:list){
            if(commentList.getState()==1){
                int commentId=commentList.getCommentId();
                List<CommentReply> listReply=commentMapper.findChild(commentId);
                for(CommentReply commentReply:listReply){
                    commentList.setReplyConnent(commentReply.getReplyConnect());
                    commentList.setReplyTime(commentReply.getReplyTime());
                }
            }
        }
        return list;
    }

    //显示个人评论总数
    @Override
    public int findCount(int userId) {
        return commentMapper.findCount(userId);
    }

    //根据商品获取商品评分
    @Override
    public String getStar(int articleId){
        double star=0;
        int cnt=0;
        List<Comment> list=commentMapper.getStar(articleId);
        Iterator<Comment> it=list.iterator();
        while(it.hasNext()){
            ++cnt;
            star+=it.next().getStar();
        }
        DecimalFormat df=new DecimalFormat("0.0");
        return df.format(star/cnt);
    }
}
