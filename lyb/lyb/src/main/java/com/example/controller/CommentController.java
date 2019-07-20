package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable int id)
    {

        return commentService.find(id).toString();
    }

    //跳转到登录页
    @RequestMapping("/toIndex")
    public String show()
    {
        return "index";
    }

    @RequestMapping("/add")
    public void add(Comment comment)
    {

        commentService.add(comment);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id)
    {
        commentService.delete(id);
        return "index";
    }

    //获取全部评论
    @RequestMapping("/find")
    @ResponseBody
    public Object findAll() throws  Exception
    {
        List<Comment> list = commentService.findAll();
        /*response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSONObject.toJSONString(comment));*/
        Iterator<Comment> it=list.iterator();
        it.next();
        return it.next().toString();
    }

    //根据用户ID和商品ID查询所有评论

    //查询该评论的所有子评论

}
