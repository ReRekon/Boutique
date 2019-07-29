package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.FocusImage;
import com.example.service.impl.FoucusImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/focus")
public class FocusController {

    @Autowired
    private FoucusImageServiceImpl focusImageServiceImpl;

    @RequestMapping("/getFocus")
    @ResponseBody
    public String queryFocusImage(){
        List<FocusImage> focusImageList = focusImageServiceImpl.queryFocusImage();

        return JSONObject.toJSONString(focusImageList);
    }

}
