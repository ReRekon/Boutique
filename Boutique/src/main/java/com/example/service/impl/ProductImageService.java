package com.example.service.impl;

import com.example.mapper.ProductImageMapper;
import com.example.entity.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    ProductImageMapper productImageMapper;

    public int add(ProductImage productImage){
        return productImageMapper.add(productImage);
    }

    public int delete(int productImageId){
        return  productImageMapper.delete(productImageId);
    }

    public int update(ProductImage productImage){
        return  productImageMapper.update(productImage);
    }

    public List<ProductImage> findAll(int procuctId){
        List<ProductImage> productImageList = null;
        productImageList = new ArrayList<ProductImage>();
        productImageList = productImageMapper.findAll(procuctId);
        return productImageList;
    }


}
