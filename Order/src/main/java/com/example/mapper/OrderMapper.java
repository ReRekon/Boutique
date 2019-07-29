package com.example.mapper;


import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface OrderMapper {

  //测试增删改查
  int insertOrder(Order order);

  void insertOrderItem(OrderItem orderItem);
  void updateOrderItem(OrderItem orderItem);


  //从用户id查询对应的购物车，再查询到购物车里面的购物车项
  ShoppingCartItem getShoppingItem(@Param("userId") int userId,@Param("shoppingCartItemId") int shoppingCartItemId);

  //通过购物车项获取商品的id,再获取商品的状态(是否已下架，或着库存不够)
  Product getState(int productId);

  //减少商品库存
  int updateProduct(@Param("productId") int productId,@Param("inventory") long inventory);

  //清空购物车，即删除购物车项
  int deleteShoppingCartItem(int ProductId);

  //若支付订单，则更新订单部分数据
  int updateOrder(@Param("orderId") int orderId,@Param("state") int state,@Param("finishTime") Date finishTime);

  //取消订单，删除订单和订单项
  void deleteOrder(int orderId);
  void deleteOrderItem(int orderId);

  //删除订单，只更新订单状态为3
  int updateDeleteOrder(@Param("orderId") int orderId,@Param("state") int state);

  //查询即将删除和取消的订单状态
  List<Order>  queryOrders(int userId);

  //查询即将付款的商品规格
  ProductSpecification findSpecification(@Param("productId") int productId,@Param("productSpecificationId") int productSpecificationId);

  //通过订单获取所有的订单项并显示出来
  List<OrderItem> queryOrderItemByOrderId(int orderId);
}
