package com.example.vo;

/**
 * @author xuegeng
 * @date 2019/8/3 - 1:26
 */
public class ProductVo {

    private int productId;
    private String name;
    private String description;
    private long inventory;
    private String logo;
    private int state;
    private float discount;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", inventory=" + inventory +
                ", logo='" + logo + '\'' +
                ", state=" + state +
                ", discount=" + discount +
                '}';
    }
}






































