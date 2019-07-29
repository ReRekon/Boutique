package com.example.entity;

public class ProductImage {
    private int productImageId;
    private int procuctId;
    private String imageURL;
    private String description;
    private int state;

    public int getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(int productImageId) {
        this.productImageId = productImageId;
    }

    public int getProcuctId() {
        return procuctId;
    }

    public void setProcuctId(int procuctId) {
        this.procuctId = procuctId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
