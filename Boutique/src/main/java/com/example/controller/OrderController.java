package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

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


    @RequestMapping("/insertOrder")
    public int insertOrder(@RequestBody JSONObject jsonObject)
    {
        Order order=jsonObject.toJavaObject(Order.class);
        return orderService.insertOrder(order);
    }

    @RequestMapping("/createOrderByShoppingCart")
    public Object createOrderByShoppingCart() {

        HttpSession session = request.getSession();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();

        //获取到所有购物车项
        List<ShoppingCartItem> list = orderService.getShoppingItem(id);

        if (list.isEmpty()) {
            System.out.println("购物车为空");
            return "购物车为空";
        }

        //初始化购物车内商品总价为0
        finalPrice = new BigDecimal(0);
        totalPrice = new BigDecimal(0);
        //初始化商品总数
        long number=0;

        for (ShoppingCartItem item : list) {

            product=orderService.getState(item.getProductId());

            if(product.getInventory()<item.getNumber())
            {
                System.out.println("该商品库存不足");
                return product.getName()+"，该商品库存不足";
            }

            if(product.getState()==-1)
            {
                System.out.println("该商品已下架");
                return product.getName()+"该商品已下架";
            }

            //状态为2为已被勾选
            if(product.getInventory()>item.getNumber()&&product.getState()==2){

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
        order.setFinalPrice(finalPrice);

        //将生成订单加入数据库
        if(orderService.insertOrder(order)==0)
        {
            return "创建订单失败";
        }

        //创建订单项
        OrderItem orderItem=new OrderItem();

        List list1=new ArrayList();
        for (ShoppingCartItem item : list)
        {
            //初始化订单项
            orderItem.setOrderId(order.getOrderId());
            orderItem.setProductId(item.getProductId());
            orderItem.setFinalPrice(item.getFinalPrice());
            orderItem.setNumber(item.getNumber());
            list1.add(orderItem);
            orderService.insertOrderItem(orderItem);
        }

        Map map=new HashMap();
        map.put("order",order);
        map.put("orderItemList",list1);

        return map;
    }

/*

    @RequestMapping("/createOrderByProduct")
    public Object createOrderByProduct(int productId,int number){

        //得到要生成订单的物品id
        Product product=orderService.queryProduct(productId);

        HttpSession session = request.getSession();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();

        //通过商品id查到商品的价格
        int price = orderService.getPrice(productId);

        //得到订单号
        long currentTime =System.currentTimeMillis();
        long orderNumber=currentTime+new Random().nextInt(100);

        //得到最终价格
        BigDecimal finalPrice=number*price*product.get

        Order order=new Order();
        //0表示已付款
        order.setState(0);
        order.setUserId(id);
        //总价是商品价格乘以数量
        order.setTotalPrice(new BigDecimal(price*number));
        order.setVerifyTime(new Date());
        order.setNumber(number);
        order.setOrderNumber(String.valueOf(orderNumber));

        order.setFinalPrice(finalPrice);
    }

*/


    @RequestMapping("/payOrder")
    public String payOrder(Map map)
    {

        Order order=(Order) map.get("order");
        List<OrderItem> list=(List) map.get("orderItemList");

        if(map==null)
        {
            //如果三十分钟未付款，则销毁订单和订单项
            orderService.deleteOrder(order.getOrderId());
            for(OrderItem item:list)
            {
                orderService.deleteOrderItem(item.getOrderItemId());
            }
        }
        else {
            /*
             * 如果付款了，则设订单完成时间，更改订单状态，减少库存，清空购物车
             */

            //设订单完成时间
            //1表示已付款

            //System.out.println(order.getId()+"-----"+order.getNumber()+"-----"+order.getOrderNumber());
            orderService.updateOrder(order.getOrderId(),1,new Date());

            for(OrderItem item:list)
            {
                //查询商品库存并减少库存
                Product product=orderService.getState(item.getProductId());
                long inventory=product.getInventory();

                inventory=inventory-item.getNumber();
                orderService.updateProduct(item.getProductId(),inventory);

            }

            /**
             * 清空购物车
             */

            HttpSession session = request.getSession();

            // 从session中获取当前登陆用户信息
            Admin admin = (Admin) session.getAttribute("admin");
            int id = admin.getUserId();

            //获取到所有购物车项
            List<ShoppingCartItem> list1 = orderService.getShoppingItem(id);

            for(ShoppingCartItem item:list1)
            {
                //如果状态为已经被勾选，则删除
                orderService.deleteShoppingCartItem(2);
            }
            return "支付成功";
        }
        return "支付失败";
    }

    @RequestMapping("/cancelOrder")
    public String cancelOrder()
    {
        HttpSession session = request.getSession();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();

        //获取当前用户的订单状态
        List<Order> list= orderService.queryOrderState(id);

        //标志订单是否被取消成功
        int tag=0;
        for(Order item:list)
        {
            //若未付款,状态为0，则删除订单和订单项,未付款的订单唯一
            if(item.getState()==0)
            {
                tag=1;
                orderService.deleteOrder(item.getOrderId());
                orderService.deleteOrderItem(item.getOrderId());

            }
        }

        if(tag==1){
            return "取消成功";
        }
        else {
            return "取消失败";
        }
    }

    @RequestMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable int orderId) {
        HttpSession session = request.getSession();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();

        System.out.println(id + "----------");

        //获取当前用户的订单状态
        List<Order> list = orderService.queryOrderState(id);

        //标志订单是否已经被删除
        int tag = 0;

        for (Order item : list) {
            if (item.getState() == 1 && item.getOrderId() == orderId) {
                //删除订单更改状态为3,为已删除状态
                orderService.updateDeleteOrder(orderId, 3);
                tag=1;
                break;
            }
        }

        if(tag==1)
            return "删除成功";
        else
            return "删除失败";
    }
}
