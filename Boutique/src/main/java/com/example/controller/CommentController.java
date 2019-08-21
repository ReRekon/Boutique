package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.vo.CommentList;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/comment")
public class CommentController {

   @Autowired
    private CommentService commentService;
   @Autowired
   private UploadController uploadController;

   //增加评论----->只能通过订单号来写评论
    @RequestMapping("/addComment")
    public int addComment(@RequestParam("orderId") int orderId,
                          @RequestParam("commentContent") String commentContent,
                          @RequestParam("pic") MultipartFile file,
                          @RequestParam("star") int star)
    {
        String pic= null;
        try {
            pic = uploadController.uploadImg(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentService.addComment(orderId,commentContent,pic,star);
    }

    //追加评论    state:0--->未评论  state:1--->未追评  state:2--->不能评论
    @RequestMapping("/reply")
    public int addReply(@RequestParam("orderId") int orderId,
                        @RequestParam("connect") String connect)
    {
        return commentService.addReply(orderId,connect);
    }

   //显示商品所有评论
    @RequestMapping("/findByArticle")
    public String findAllCommentByArticle(@RequestParam("articleId") int articleId)
    {
        List<CommentList> list=commentService.findAllCommentByArticle(articleId);
       // System.out.println(JSONObject.toJSONString(list));
        return JSONObject.toJSONString(list);
    }

    //显示用户的所有评论
    @RequestMapping("/findByUser")
    public String findAllCommentByUser(HttpServletRequest request)
    {
        List<CommentList> list=commentService.findAllCommentByUser(request);
        return JSONObject.toJSONString(list);
    }

    //显示个人评论总数
    @RequestMapping("/count")
    public int findCount(HttpServletRequest request)
    {
        return commentService.findCount(request);
    }

    //显示商品评分
    @RequestMapping("/star")
    public String getStar(@RequestParam("articleId") int articleId)
    {
        String star=commentService.getStar(articleId);
        return star;
    }
}