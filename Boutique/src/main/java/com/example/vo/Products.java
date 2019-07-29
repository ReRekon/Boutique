package com.example.vo;

import com.example.entity.Product;
import com.example.entity.ProductSpecification;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Products {
    private  Product product;
    private ArrayList<ProductSpecification> productSpecification;
    private BigDecimal price;
    private ArrayList<String> img;

    public ArrayList<String> getImg() {
        return img;
    }

    public void setImg(ArrayList<String> img) {
        this.img = img;
    }

    public ArrayList<ProductSpecification> getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ArrayList<ProductSpecification> productSpecification) {
        this.productSpecification = productSpecification;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
