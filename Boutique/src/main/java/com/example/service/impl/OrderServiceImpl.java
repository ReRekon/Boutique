package com.example.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import com.example.vo.ReturnOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    //获取用户信息
    @Autowired
    private HttpServletRequest request;

    //获取购物车总价
    private BigDecimal finalPrice;
    private BigDecimal totalPrice;

    //获取当前商品
    private Product product;


    public int insertOrder(@RequestBody JSONObject jsonObject)
    {
        Order order=jsonObject.toJavaObject(Order.class);
        return orderMapper.insertOrder(order);
    }


    //接受前端传给我的要处理的购物车的购物车项id
    public ReturnOrder createOrderByShoppingCart(@PathVariable List<Integer> idList) {

        HttpSession session = request.getSession();
        ReturnOrder returnOrder=new ReturnOrder();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();

        //获取到所选购物车项

        List<ShoppingCartItem> list = new ArrayList<ShoppingCartItem>();

        for(Integer item:idList)
        {
            list.add(orderMapper.getShoppingItem(id,item));
        }

        //初始化购物车内商品总价为0
        finalPrice = new BigDecimal(0);
        totalPrice = new BigDecimal(0);
        //初始化商品总数
        long number=0;

        for (ShoppingCartItem item : list) {

            // System.out.println(item.getProductId());
            product= orderMapper.getState(item.getProductId());

            if(product.getInventory()<item.getNumber())
            {
                System.out.println("该商品库存不足");

                returnOrder.setString("该商品库存不足");
                returnOrder.setMap(null);

                return returnOrder;

            }

            if(product.getState()==-1)
            {
                System.out.println("该商品已下架");

                returnOrder.setString("该商品已下架");
                returnOrder.setMap(null);

                return returnOrder;
            }


            finalPrice = finalPrice.add(item.getFinalPrice());//计算出订单的折后总价
            totalPrice= totalPrice.add(item.getTotalPrice());//计算出订单的折前价


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
        if(orderMapper.insertOrder(order)==0)
        {
            returnOrder.setString("创建订单失败");
            returnOrder.setMap(null);

            return returnOrder;
        }

        //创建订单项
        OrderItem orderItem=new OrderItem();

        List list1=new ArrayList();
        for (ShoppingCartItem item : list)
        {
            //初始化订单项和商品规格
            orderItem.setOrderId(order.getOrderId());
            orderItem.setProductId(item.getProductId());
            orderItem.setFinalPrice(item.getFinalPrice());
            orderItem.setNumber(item.getNumber());
            orderItem.setLogo(item.getLogo());
            orderItem.setProductSpecificationId(item.getProductSpecificationId());


            //获得商品规格
            orderItem.setProductSpecification(orderMapper.findSpecification(item.getProductId(),item.getProductSpecificationId()));
            orderItem.setProductName(orderMapper.getState(item.getProductId()).getName());

            list1.add(orderItem);
            orderMapper.insertOrderItem(orderItem);
        }

        Map map=new HashMap();

        order.setOrderItem(list1);

        map.put("order",order);
        returnOrder.setString(null);

        returnOrder.setMap(map);

        return returnOrder;
    }



    public String payOrder(Map map)
    {

        Order order=(Order) map.get("order");
        List<OrderItem>  list=order.getOrderItem();

        if(map==null)
        {
            //如果三十分钟未付款，则销毁订单和订单项
            orderMapper.deleteOrder(order.getOrderId());
            for(OrderItem item:list)
            {
                orderMapper.deleteOrderItem(item.getOrderItemId());
            }
        }
        else {
            /*
             * 如果付款了，则设订单完成时间，更改订单状态，减少库存，清空购物车
             */

            //设订单完成时间
            //1表示已付款

            //System.out.println(order.getId()+"-----"+order.getNumber()+"-----"+order.getOrderNumber());
            orderMapper.updateOrder(order.getOrderId(),1,new Date());

            for(OrderItem item:list)
            {
                //查询商品库存并减少库存
                Product product= orderMapper.getState(item.getProductId());
                long inventory=product.getInventory();

                inventory=inventory-item.getNumber();
                orderMapper.updateProduct(item.getProductId(),inventory);

            }

            /**
             * 清空购物车
             */

            HttpSession session = request.getSession();

            // 从session中获取当前登陆用户信息
            Admin admin = (Admin) session.getAttribute("admin");
            int id = admin.getUserId();


            for(OrderItem item:list)
            {
                //如果状态为已经被勾选，则删除
                orderMapper.deleteShoppingCartItem(item.getProductId());
            }
            return "支付成功";
        }
        return "支付失败";
    }


    public String cancelOrder()
    {
        HttpSession session = request.getSession();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();

        //获取当前用户的订单状态
        List<Order> list= orderMapper.queryOrders(id);

        //标志订单是否被取消成功
        int tag=0;
        for(Order item:list)
        {
            //若未付款,状态为0，则删除订单和订单项,未付款的订单唯一
            if(item.getState()==0)
            {
                tag=1;
                orderMapper.deleteOrder(item.getOrderId());
                orderMapper.deleteOrderItem(item.getOrderId());

            }
        }

        if(tag==1){
            return "取消成功";
        }
        else {
            return "取消失败";
        }
    }


    public String deleteOrder(int orderId) {
        HttpSession session = request.getSession();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();


        //获取当前用户的订单状态
        List<Order> list = orderMapper.queryOrders(id);

        //标志订单是否已经被删除
        int tag = 0;

        for (Order item : list) {

            System.out.println(item.getOrderId());
            System.out.println(item.getState());

            if (item.getState() == 1 && item.getOrderId() == orderId) {
                //删除订单更改状态为3,为已删除状态
                orderMapper.updateDeleteOrder(orderId, 3);
                tag=1;
                break;
            }
        }

        if(tag==1)
            return "删除成功";
        else
            return "删除失败";
    }

    public ReturnOrder findAllOrders()
    {
        HttpSession session = request.getSession();

        // 从session中获取当前登陆用户信息
        Admin admin = (Admin) session.getAttribute("admin");
        int id = admin.getUserId();

        //封装返回对象
        ReturnOrder returnOrder=new ReturnOrder();

        List<Order> orderList= orderMapper.queryOrders(id);

        if(orderList==null)
        {
            returnOrder.setString("订单为空");
            return  returnOrder;
        }

        Map map=new HashMap();


        for(Order item : orderList){
            List<OrderItem> orderItemList=orderMapper.queryOrderItemByOrderId(item.getOrderId());
            item.setOrderItem(orderItemList);
            for (OrderItem orderItem : orderItemList)
            {
                ProductSpecification productSpecification=orderMapper.findSpecification(orderItem.getProductId(),orderItem.getProductSpecificationId());
                orderItem.setProductSpecification(productSpecification);
            }
        }

        map.put("orderList",orderList);

        returnOrder.setMap(map);

        return  returnOrder;
    }


}
