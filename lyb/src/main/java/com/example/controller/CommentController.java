package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Comment;
import com.example.entity.CommentList;
import com.example.serviceImpl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //查询该评论的所有子评论
    @RequestMapping("/findChild")
    @ResponseBody
    public String findChild(@RequestParam("commentId") int commentId)
    {
        List<Comment> list=new ArrayList<Comment>();
        list=commentService.findChild(commentId);
        Iterator<Comment> it=list.iterator();
        return JSONObject.toJSONString(list);
    }

    //增加评论------>只能通过订单来写评论
    @RequestMapping("/addcomment")
    @ResponseBody
    public void addCommentByOrder(@RequestParam("orderId") int orderId,@RequestParam("commentContent") String commentContent,@RequestParam("pic") String pic){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        commentService.addCommentByOrder(orderId,commentContent,date,pic);
    }

    //查找评论列表
    @RequestMapping("/findcomment")
    @ResponseBody
    public String findAllComment(@RequestParam("articleId") int articleId)
    {
        CommentList commentList=new CommentList();
        List<CommentList> list=new ArrayList<CommentList>();
        list=commentService.findAllComment(articleId);
        return JSONObject.toJSONString(list);
    }

    //获取用户所有评论------->根据用户ID
    @RequestMapping("/findbyid")
    @ResponseBody
    public String findAllById(@RequestParam("userId") int userId,HttpServletRequest request)
    {
        User user=(User) request.getSession().getAttribute("user");
        List<CommentList> list=new ArrayList<CommentList>();
        list=commentService.findById(user.getUserId());
        return JSONObject.toJSONString(list);
    }

    //显示个人评论总数
    @RequestMapping("/findCount")
    @ResponseBody
    public int findCount(@RequestParam("userId") int userId)
    {
        return commentService.findCount(userId);
    }
}
