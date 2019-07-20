package com.example.mapper;


import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.entity.Product;
import com.example.entity.ShoppingCartItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface OrderMapper {

  //测试增删改查
  Order queryOrder(int id);
  int insertOrder(Order order);
  void updateOrder(Order order);
  void deleteOrder(int id);
  OrderItem queryOrderItem(int id);
  void insertOrderItem(OrderItem orderItem);
  void updateOrderItem(OrderItem orderItem);
  void deleteOrderItem(int id);

  //从用户id查询对应的购物车，再查询到购物车里面的购物车项
  List<ShoppingCartItem> getShoppingItem(int id);

  //通过购物车项获取商品的id,再获取商品的状态(是否已下架，或着库存不够)
  Product getState(int id);
}
