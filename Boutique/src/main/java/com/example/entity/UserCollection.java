package com.example.entity;

import java.util.Date;

public class UserCollection {
    private int  userCollectionId;
    private int  productId;
    private int  userId;
    private Date enterTime;
    private int  state;

    @Override
    public String toString() {
        return "UserCollection [userCollectionId=" + userCollectionId + ", productId=" + productId
               + ", userId=" + userId + ", enterTime=" + enterTime + ", state=" + state + "]";
    }

    public int getUserCollectionId() {
        return userCollectionId;
    }

    public void setUserCollectionId(int userCollectionId) {
        this.userCollectionId = userCollectionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

}
