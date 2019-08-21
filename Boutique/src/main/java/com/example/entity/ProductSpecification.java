package com.example.entity;

import java.math.BigDecimal;

public class ProductSpecification {
    private int productSpecificationId;
    private int productId;
    private String description;
    private BigDecimal price;       
    private BigDecimal nprice;

    public BigDecimal getNprice() {
        return nprice;
    }

    public void setNprice(BigDecimal nprice) {
        this.nprice = nprice;
    }

    public int getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(int productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductSpecification{" +
                "productSpecificationId=" + productSpecificationId +
                ", productId=" + productId +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
