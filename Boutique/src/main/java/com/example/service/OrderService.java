package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.*;
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
