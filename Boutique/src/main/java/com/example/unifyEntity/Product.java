package com.example.unifyEntity;

public class Product {
    private int productId;
    private String name;
    private String description;
    private long collectTimes;
    private long inventory;
    private int heat;
    private float mark;
    private int state;
    private  Float discount;
    private String logo;

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

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", collectTimes=" + collectTimes +
                ", inventory=" + inventory +
                ", heat=" + heat +
                ", mark=" + mark +
                ", state=" + state +
                ", discount=" + discount +
                ", logo='" + logo + '\'' +
                '}';
    }
}
