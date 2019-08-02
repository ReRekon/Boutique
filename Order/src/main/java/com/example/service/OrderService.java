package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;
import java.util.Map;

public interface OrderService {

    int insertOrder(Order order);

    ReturnOrder createOrderByShoppingCart(List<Integer> idList);

    String payOrder(Map map);

    String cancelOrder();

    String deleteOrder(int orderId);

    ReturnOrder findAllOrders();
}
