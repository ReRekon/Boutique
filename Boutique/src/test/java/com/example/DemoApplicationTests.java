package com.example;


import com.alibaba.fastjson.JSON;
import com.example.controller.OrderController;
import com.example.entity.Admin;
import com.example.entity.Order;
import com.example.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    OrderController orderController;

    @Autowired
    HttpServletRequest httpServletRequest;


    @Test
    public void contextLoads() {

        Order order=new Order();
        order.setState(0);
        order.setFinalPrice(new BigDecimal(200));
        order.setFinishTime(new java.util.Date());
        order.setNumber(100);
        order.setVerifyTime(new java.util.Date());
        order.setUserId(1);
        order.setTotalPrice(new BigDecimal(100));

        String str= JSON.toJSONString(order);
        System.out.println(str);
       //orderController.Insert_order(order);
    }

    @Test
    public void OrderItemTest(){

        OrderItem orderItem=new OrderItem();
        orderItem.setNumber(100);
        orderItem.setFinalPrice(new BigDecimal(30));
        orderItem.setOrderId(1);
        orderItem.setProductId(1);

        String str=JSON.toJSONString(orderItem);
        System.out.println(str);
    }

    @Test
    public void getShoppingCartItem(){

        Admin admin=new Admin();
        admin.setId(1);
        admin.setEmail("44444");
        admin.setImageURL("dfsd");
        admin.setVip(100);
        admin.setName("afda");
        admin.setTel("3123131");

        httpServletRequest.getSession().setAttribute("admin",admin);
        orderController.createOrder();
    }

}
