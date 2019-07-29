package com.example.vo;

public class Result {
    private  int productId;
    private  int number;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Result{" +
                "productId=" + productId +
                ", number=" + number +
                '}';
    }
}
