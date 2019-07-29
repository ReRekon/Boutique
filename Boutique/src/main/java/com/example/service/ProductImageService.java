package com.example.service;

import com.example.entity.ProductImage;

import java.util.List;

public interface ProductImageService {

    public int add(ProductImage productImage);

    public int delete(int productImageId);

    public int update(ProductImage productImage);

    public List<ProductImage> findAll(int procuctId);
}
