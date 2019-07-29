package com.example.service;

import com.example.entity.ProductImage;

import java.util.List;

public interface ProductImageServiceImpl {

    int add(ProductImage productImage);
    int delete(int productImageId);
    int update(ProductImage productImage);
    List<ProductImage> findAll(int procuctId);
}
