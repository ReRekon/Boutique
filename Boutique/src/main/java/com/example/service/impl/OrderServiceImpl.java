package com.example.service.impl;


import com.example.entity.*;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<Order>  queryOrders(int userId)
    {
        return orderMapper.queryOrders(userId);
    }

    public int insertOrder(Order order)
    {
       return orderMapper.insertOrder(order);
    }

    public void deleteOrder(int orderId)
    {
        orderMapper.deleteOrder(orderId);
    }

    public List<OrderItem> queryOrderItemByOrderId(int orderId)
    {
        return orderMapper.queryOrderItemByOrderId(orderId);
    }

    public void insertOrderItem(OrderItem orderItem)
    {
        orderMapper.insertOrderItem(orderItem);
    }

    public void updateOrderItem(OrderItem orderItem)
    {
        orderMapper.updateOrderItem(orderItem);
    }

    public void deleteOrderItem(int orderId)
    {
        orderMapper.deleteOrderItem(orderId);
    }

    public ShoppingCartItem getShoppingItem(int userId,int shoppingCartItemId){

        return  orderMapper.getShoppingItem(userId,shoppingCartItemId);
    }

    public Product getState(int productId){
        return orderMapper.getState(productId);
    }

    public int updateProduct(int productId,long inventory){
        return orderMapper.updateProduct(productId,inventory);
    }

    public int deleteShoppingCartItem(int state){
        return orderMapper.deleteShoppingCartItem(state);
    }

    public int updateOrder(int orderId, int state, Date finishTime){
        return orderMapper.updateOrder(orderId,state,finishTime);
    }

    public int updateDeleteOrder(int orderId, int state){
        return orderMapper.updateDeleteOrder(orderId,state);
    }

    public ProductSpecification findSpecification(@Param("productId") int productId, @Param("productSpecificationId") int productSpecificationId){
        return orderMapper.findSpecification(productId,productSpecificationId);
    }


}
