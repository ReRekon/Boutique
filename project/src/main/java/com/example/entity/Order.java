package com.example.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private int orderId;
    private int userId;
    private int state;
    private BigDecimal totalPrice;
    private long number;
    private BigDecimal finalPrice;
    private Date verifyTime;
    private Date finishTime;
    private String orderNumber;
}
