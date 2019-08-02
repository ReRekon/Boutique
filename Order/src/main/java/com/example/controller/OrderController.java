package com.example.controller;

import com.example.entity.*;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/testBoot")
@Transactional
public class OrderController
{
    @Autowired
    private OrderService orderServiceImpl;

    @ResponseBody
    @RequestMapping("/insertOrder")
    public int insertOrder(@RequestBody Order order)
    {
       return  orderServiceImpl.insertOrder(order);
    }

    @PostMapping("/createOrderByShoppingCart")
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

    @RequestMapping("/findAllOrders")
    public ReturnOrder findAllOrders(){
        return orderServiceImpl.findAllOrders();
    }

}
