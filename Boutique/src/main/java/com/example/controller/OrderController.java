package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Admin;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.entity.ShoppingCartItem;
import com.example.service.OrderService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/testBoot")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    //获取用户信息
    @Autowired
    private HttpServletRequest request;

    //获取购物车总价
    private BigDecimal finalPrice;
    private BigDecimal totalPrice;

    //获取当前商品
    private Product product;

    @RequestMapping("/queryOrder/{id}")
    public String queryOrder(@PathVariable int id)
    {
        return orderService.queryOrder(id).toString();
    }

    @RequestMapping("/insertOrder")
    public int insertOrder(@RequestBody JSONObject jsonObject)
    {
        Order order=jsonObject.toJavaObject(Order.class);
        return orderService.insertOrder(order);
    }

    @RequestMapping("/updateOrder")
    public void updateOrder(@RequestBody JSONObject jsonObject)
    {
        Order order=jsonObject.toJavaObject(Order.class);
        orderService.updateOrder(order);
    }

    @RequestMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable int id)
    {
        orderService.deleteOrder(id);
    }

    //@RequestMapping("/createOrder")

    public Object createOrder() {
        HttpSession session = request.getSession();

        Admin admin = (Admin) session.getAttribute("admin");// 从session中获取当前登陆用户信息

        int id = admin.getId();

        List<ShoppingCartItem> list = orderService.getShoppingItem(id);//获取到所有购物车项

        if (list.isEmpty()) {
            return "购物车为空";
        }

        //初始化购物车内商品总价为0
        finalPrice = new BigDecimal(0);
        totalPrice = new BigDecimal(0);
        //初始化商品总数
        long number=0;

        for (ShoppingCartItem item : list) {

            product=orderService.getState(item.getProductId());

            if(product.getInventory()==0){
                return product.getName()+"，该商品库存不足";
            }

            if(product.getState()==0)
            {
                return product.getName()+"该商品已下架";
            }


            if(product.getInventory()>0&&product.getState()==2){

                finalPrice = finalPrice.add(item.getFinalPrice());//计算出订单的折后总价
                totalPrice= totalPrice.add(item.getTotalPrice());//计算出订单的折前价
            }

            //计算出商品总数
            number=number+item.getNumber();

        }

        //生成订单号
        long currentTime =System.currentTimeMillis();
        long orderNumber=currentTime+new Random().nextInt(100);

        //创建订单
        Order order=new Order();
        order.setUserId(id);
        order.setTotalPrice(totalPrice);
        order.setVerifyTime(new Date());
        order.setNumber(number);
        order.setState(0);
        order.setOrderNumber(String.valueOf(orderNumber));
        order.setTotalPrice(totalPrice);
        order.setFinalPrice(finalPrice);

        //将生成订单加入数据库
        if(orderService.insertOrder(order)==0)
        {
            return "创建订单失败";
        }
        return order;

    }

}
