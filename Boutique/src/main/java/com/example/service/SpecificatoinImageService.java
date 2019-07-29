package com.example.service;

import com.example.entity.SpecificationImage;

import java.util.List;

public interface SpecificatoinImageService {

    public int add(SpecificationImage specificationImage);

    public int delete(int specificationImageId);

    public int update(SpecificationImage specificationImage);

    public List<SpecificationImage> findAll(int productId);
}
