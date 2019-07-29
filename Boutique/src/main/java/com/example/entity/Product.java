package com.example.entity;

public class Product {
    private int productId;
    private int productTypeId;  //一级分类
    private int productTypeId2; //二级分类
    private String name;
    private String description;
    private long collectTimes;
    private long inventory;
    private String logo;
    private int heat;
    private float mark;
    private int state;
    private float discount;

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getProductTypeId2() {
        return productTypeId2;
    }

    public void setProductTypeId2(int productTypeId2) {
        this.productTypeId2 = productTypeId2;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCollectTimes() {
        return collectTimes;
    }

    public void setCollectTimes(long collectTimes) {
        this.collectTimes = collectTimes;
    }

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTypeId=" + productTypeId +
                ", productTypeId2=" + productTypeId2 +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", collectTimes=" + collectTimes +
                ", inventory=" + inventory +
                ", logo='" + logo + '\'' +
                ", heat=" + heat +
                ", mark=" + mark +
                ", state=" + state +
                ", discount=" + discount +
                '}';
    }
}
