package com.example.controller;

import com.alibaba.fastjson.JSONObject;

import com.example.entity.Admin;
import com.example.entity.Product;
import com.example.service.impl.CFServiceImpl;
import com.example.vo.ProductVo;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CFController {
    @Autowired
    private CFServiceImpl cfServiceImpl;

    @Autowired
    private HttpServletRequest request;

    private ProductVo gyl;


    //根据用户Id获取猜你喜欢物品
    @RequestMapping("/gyl")
    public String GuessYouLikes(){
        //获取用户Id
        HttpSession session=request.getSession();
        Admin admin=(Admin)session.getAttribute("Admin");
        List<Result> result = cfServiceImpl.findProductIdAndNumberByAdminId(admin.getUserId());
        Map<Integer,Integer> maps = new HashMap();
        for(Result results: result){
            if(maps.containsKey(results.getProductId())){
                maps.put(results.getProductId(),maps.get(results.getProductId()) + results.getNumber());
            }else{
                maps.put(results.getProductId(), results.getNumber());
            }
        }
        

        List<Integer> type = new ArrayList<>();
        Set keySet = maps.keySet();
        Iterator it = keySet.iterator();

        while(it.hasNext()){
            int key = (Integer)it.next();
            type = cfServiceImpl.resultProductTypeId(key);
        }

        List<ProductVo> guessYouLikes = new ArrayList<>();
        for (Integer last:type) {
            guessYouLikes =cfServiceImpl.findGuessYouLikes(last);
        }

        //过滤数据
//        int anInt = 0;
//        Map<Integer, ProductVo> gyls = new HashMap<Integer,ProductVo>();
//        Iterator<Product> things = guessYouLikes.iterator();
//        while(things.hasNext()) {
//
//                gyl.setName(things.next().getName());
//                gyl.setProductId(things.next().getProductId());
//                gyl.setLogo(things.next().getLogo());
//                gyl.setDiscount(things.next().getDiscount());
//                gyl.setState(things.next().getState());
//                gyl.setInventory(things.next().getInventory());
//                gyl.setDescription(things.next().getDescription());
//
//
//                gyls.put(anInt,gyl);
//                ++anInt;
//
//        }


        return JSONObject.toJSONString(guessYouLikes);
    }

}
