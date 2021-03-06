package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.vo.ReturnOrder;
import com.example.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/testBoot")
@Transactional
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController
{
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping("/insertOrder")
    public int insertOrder(JSONObject jsonObject)
    {
       return  orderServiceImpl.insertOrder(jsonObject);
    }

    @RequestMapping("/createOrderByShoppingCart")
    public ReturnOrder createOrderByShoppingCart(List<Integer> idList){
        return orderServiceImpl.createOrderByShoppingCart(idList);
    }

    @RequestMapping("/payOrder")
    public String payOrder(Map map){
        return orderServiceImpl.payOrder(map);
    }

    @RequestMapping("/cancelOrder")
    public String cancelOrder(){
        return orderServiceImpl.cancelOrder();
    }

    @RequestMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable int orderId){
        return orderServiceImpl.deleteOrder(orderId);
    }

    public ReturnOrder findAllOrders(){
        return orderServiceImpl.findAllOrders();
    }

}
