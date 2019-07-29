package com.example.controller;

import com.alibaba.fastjson.JSONObject;

import com.example.entity.Admin;
import com.example.entity.Product;
import com.example.service.impl.CFServiceImpl;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/user")
public class CFController {
    @Autowired
    private CFServiceImpl cfServiceImpl;

    @Autowired
    private HttpServletRequest request;

    //获取用户Id
    HttpSession session=request.getSession();
    Admin admin=(Admin)session.getAttribute("Admin");
    List<Result> results = cfServiceImpl.findProductIdAndNumberByAdminId(admin.getUserId());

    //根据用户Id获取猜你喜欢物品
    @RequestMapping("/gyl")
    public void GuessYouLikes(){

        Map<Integer,Integer> maps = new HashMap();
        for(Result results: results){
            if(maps.containsKey(results.getProductId())){
                maps.put(results.getProductId(),maps.get(results.getProductId()) + results.getNumber());
            }else{
                maps.put(results.getProductId(), results.getNumber());
            }
        }

//        sortMapByValueService.sortByValue(maps);
        List<Integer> type = new ArrayList<>();
        Set keySet = maps.keySet();
        Iterator it = keySet.iterator();

        while(it.hasNext()){
            int key = (Integer)it.next();
            type = cfServiceImpl.resultProductTypeId(key);
        }

        List<Product> guessYouLikes = new ArrayList<>();
        for (Integer last:type) {
            guessYouLikes =cfServiceImpl.findGuessYouLike(last);
        }

        //Iterator<Product> things = guessYouLikes.iterator();
        String s = JSONObject.toJSONString(guessYouLikes);
    }

}
