package com.example.entity;

public class ProductType2 {
    private int productTypeId2;
    private String ProductTypeName2;
    private int state2;
    private int productTypeId;

    public int getProductTypeId2() {
        return productTypeId2;
    }

    public void setProductTypeId2(int productTypeId2) {
        this.productTypeId2 = productTypeId2;
    }

    public String getProductTypeName2() {
        return ProductTypeName2;
    }

    public void setProductTypeName2(String productTypeName2) {
        ProductTypeName2 = productTypeName2;
    }

    public int getState2() {
        return state2;
    }

    public void setState2(int state2) {
        this.state2 = state2;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Override
    public String toString() {
        return "ProductType2{" +
                "productTypeId2=" + productTypeId2 +
                ", ProductTypeName2='" + ProductTypeName2 + '\'' +
                ", state2=" + state2 +
                ", productTypeId=" + productTypeId +
                '}';
    }
}
