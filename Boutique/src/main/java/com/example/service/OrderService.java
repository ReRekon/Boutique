package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.vo.ReturnOrder;

import java.util.List;
import java.util.Map;

public interface OrderService {

    int insertOrder(JSONObject jsonObject);

    ReturnOrder createOrderByShoppingCart(List<Integer> idList);

    String payOrder(Map map);

    String cancelOrder();

    String deleteOrder(int orderId);

    ReturnOrder findAllOrders();
}
