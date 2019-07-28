package com.example.unifyEntity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCartItem {
    private int shoppingCartItemId;
    private int productId;
    private int shoppingCartId;
    private int productSpecificationId;
    private long number;
    private int state;   //1：有货  0：无货
    private BigDecimal finalPrice;
    private BigDecimal totalPrice;
    private String logo;


    public int getShoppingCartItemId() {
        return shoppingCartItemId;
    }

    public void setShoppingCartItemId(int shoppingCartItemId) {
        this.shoppingCartItemId = shoppingCartItemId;
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

    public int getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(int productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "shoppingCartItemId=" + shoppingCartItemId +
                ", productId=" + productId +
                ", shoppingCartId=" + shoppingCartId +
                ", productSpecificationId=" + productSpecificationId +
                ", number=" + number +
                ", state=" + state +
                ", finalPrice=" + finalPrice +
                ", totalPrice=" + totalPrice +
                ", logo='" + logo + '\'' +
                '}';
    }
}
