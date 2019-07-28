package com.example.unifyEntity;

public class ShoppingCart {
    private int shoppingCartId;
    private int userId;

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartId=" + shoppingCartId +
                ", userId=" + userId +
                '}';
    }
}
