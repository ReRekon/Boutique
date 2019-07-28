package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Comment;
import com.example.entity.CommentList;
import com.example.entity.CommentReply;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

   @Autowired
    private CommentService commentService;

   //增加评论----->只能通过订单号来写评论
    @RequestMapping("/addComment")
    public int addComment(@RequestParam("orderId") int orderId,
                          @RequestParam("commentContent") String commentContent,
                          @RequestParam("pic") String pic,
                          @RequestParam("star") int star)
    {
        return commentService.addComment(orderId,commentContent,pic,star);
    }

    //追加评论    state:0--->未评论  state:1--->未追评  state:2--->不能评论
    @RequestMapping("/reply")
    public int addReply(@RequestParam("orderId") int orderId,@RequestParam("connect") String connect)
    {
        return commentService.addReply(orderId,connect);
    }

   //显示商品所有评论
    @RequestMapping("/findByArticle")
    public String findAllCommentByArticle(@RequestParam("articleId") int articleId)
    {
        List<CommentList> list=commentService.findAllCommentByArticle(articleId);
        return JSONObject.toJSONString(list);
    }

    //显示用户的所有评论
    @RequestMapping("/findByUser")
    public String findAllCommentByUser(@RequestParam("userId") int userId)
    {
        List<CommentList> list=commentService.findAllCommentByUser(userId);
        return JSONObject.toJSONString(list);
    }

    //显示个人评论总数
    @RequestMapping("/count")
    public int findCount(@RequestParam("userId") int userId)
    {
        return commentService.findCount(userId);
    }

    //显示商品评分
    @RequestMapping("/star")
    public String getStar(@RequestParam("articleId") int articleId)
    {
        String star=commentService.getStar(articleId);
        return star;
    }
}