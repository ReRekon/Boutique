package com.example.service;

import com.example.entity.SpecificationImage;

import java.util.List;

public interface SpecificationImageServiceImpl {

    int add(SpecificationImage specificationImage);
    int delete(int specificationImageId);
    int update(SpecificationImage specificationImage);
    List<SpecificationImage> findAll(int productId);
}
