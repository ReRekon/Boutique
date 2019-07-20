package com.example.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCartItem {
    private int id;
    private int productId;
    private int shoppingCartId;
    private long number;
    private Date enterTime;
    private int state;
    private BigDecimal finalPrice;
    private BigDecimal totalPrice;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }
}
