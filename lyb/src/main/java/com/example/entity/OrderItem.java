package com.example.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private int orderItemId;
    private int orderId;
    private int productId;
    private int	productSpecificationId;
    private String logo;
    private long number;
    private BigDecimal finalPrice;
}
