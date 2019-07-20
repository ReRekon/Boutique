package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.OrderItem;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testBoot")
public class OrderItemController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrder_item/{id}")
    public String queryOrderItem(@PathVariable int id)
    {
        return orderService.queryOrderItem(id).toString();
    }

    @RequestMapping("/insertOrderItem")
    public void insertOrder(@RequestBody JSONObject jsonObject)
    {
        OrderItem orderItem=jsonObject.toJavaObject(OrderItem.class);
        orderService.insertOrderItem(orderItem);
    }

    @RequestMapping("/updateOrderItem")
    public void updateOrderItem(@RequestBody JSONObject jsonObject)
    {
        OrderItem orderItem=jsonObject.toJavaObject(OrderItem.class);
        orderService.updateOrderItem(orderItem);
    }

    @RequestMapping("/deleteOrderItem/{id}")
    public void deleteOrder(@PathVariable int id)
    {
        orderService.deleteOrderItem(id);
    }
}
