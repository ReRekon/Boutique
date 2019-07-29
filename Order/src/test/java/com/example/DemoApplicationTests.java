package com.example;


import com.alibaba.fastjson.JSON;
import com.example.controller.OrderController;
import com.example.entity.Admin;
import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.entity.ReturnOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    OrderController orderController;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    DataSource dataSource;



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
        admin.setUserId(1);
        admin.setEmail("44444");
        admin.setImageURL("dfsd");
        admin.setVip(100);
        admin.setName("afda");
        admin.setTel("3123131");

        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        httpServletRequest.getSession().setAttribute("admin",admin);
        ReturnOrder returnOrder=orderController.createOrderByShoppingCart(list);
        String string=returnOrder.toString();

        System.out.println(string);
    }

    @Test
    public void payOrderTest(){
        Admin admin=new Admin();
        admin.setUserId(1);
        admin.setEmail("44444");
        admin.setImageURL("dfsd");
        admin.setVip(100);
        admin.setName("afda");
        admin.setTel("3123131");

        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);


        httpServletRequest.getSession().setAttribute("admin",admin);
        ReturnOrder returnOrder=orderController.createOrderByShoppingCart(list);


        Map map=returnOrder.getMap();
        System.out.println(map);
        String str=orderController.payOrder(map);
        System.out.println(str);
    }

    @Test
    public void cancelTest()
    {
        Admin admin=new Admin();
        admin.setUserId(1);
        admin.setEmail("44444");
        admin.setImageURL("dfsd");
        admin.setVip(100);
        admin.setName("afda");
        admin.setTel("3123131");
        httpServletRequest.getSession().setAttribute("admin",admin);

       // Map map=(Map) orderController.createOrderByShoppingCart();
        String str=orderController.cancelOrder();
        System.out.println(str);
    }

    @Test
    public void deleteOrderTest()
    {
        Admin admin=new Admin();
        admin.setUserId(1);
        admin.setEmail("44444");
        admin.setImageURL("dfsd");
        admin.setVip(100);
        admin.setName("afda");
        admin.setTel("3123131");
        httpServletRequest.getSession().setAttribute("admin",admin);

        String str=orderController.deleteOrder(1);
        System.out.println(str);
    }

    @Test
    public void testReturnOrder()
    {

        Admin admin=new Admin();
        admin.setUserId(1);
        admin.setEmail("44444");
        admin.setImageURL("dfsd");
        admin.setVip(100);
        admin.setName("afda");
        admin.setTel("3123131");
        httpServletRequest.getSession().setAttribute("admin",admin);

        ReturnOrder returnOrder=orderController.findAllOrders();
        System.out.println(returnOrder);
    }
}
