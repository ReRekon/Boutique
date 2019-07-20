package com.example.service;


import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.entity.Product;
import com.example.entity.ShoppingCartItem;
import com.example.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public Order queryOrder(int id)
    {
        return orderMapper.queryOrder(id);
    }

    public int insertOrder(Order order)
    {
       return orderMapper.insertOrder(order);
    }

    public void updateOrder(Order order)
    {
        orderMapper.updateOrder(order);
    }

    public void deleteOrder(int id)
    {
        orderMapper.deleteOrder(id);
    }

    public OrderItem queryOrderItem(int id)
    {
        return orderMapper.queryOrderItem(id);
    }

    public void insertOrderItem(OrderItem orderItem)
    {
        orderMapper.insertOrderItem(orderItem);
    }

    public void updateOrderItem(OrderItem orderItem)
    {
        orderMapper.updateOrderItem(orderItem);
    }

    public void deleteOrderItem(int id)
    {
        orderMapper.deleteOrderItem(id);
    }

    public List<ShoppingCartItem> getShoppingItem(int id){

        return  orderMapper.getShoppingItem(id);
    }

    public Product getState(int id){
        return orderMapper.getState(id);
    }
}
