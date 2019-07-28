package com.example.service;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> queryOrders(int userId);


    int insertOrder(Order order);


    void deleteOrder(int orderId);

    void insertOrderItem(OrderItem orderItem);

    void deleteOrderItem(int orderId);


    ShoppingCartItem getShoppingItem(int userId,int shoppingCartItemId);


    Product getState(int productId);

    int updateProduct(int productId,long inventory);

    int deleteShoppingCartItem(int state);

    int updateOrder(int orderId, int state, Date finishTime);

    int updateDeleteOrder(int orderId, int state);


    ProductSpecification findSpecification(@Param("productId") int productId, @Param("productSpecificationId") int productSpecificationId);

    List<OrderItem> queryOrderItemByOrderId(int orderId);
}
