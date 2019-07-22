package com.example.service;


import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.entity.Product;
import com.example.entity.ShoppingCartItem;
import com.example.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order>  queryOrderState(int userId)
    {
        return orderMapper.queryOrderState(userId);
    }

    public int insertOrder(Order order)
    {
       return orderMapper.insertOrder(order);
    }

    public void deleteOrder(int orderId)
    {
        orderMapper.deleteOrder(orderId);
    }

    public OrderItem queryOrderItem(int orderItemId)
    {
        return orderMapper.queryOrderItem(orderItemId);
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

    public List<ShoppingCartItem> getShoppingItem(int userId){

        return  orderMapper.getShoppingItem(userId);
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

/*    public Product queryProduct(int productId){
        return orderMapper.queryProduct(productId);
    }

    public int getPrice(int productId){
        return orderMapper.getPrice(productId);
    }*/
}
