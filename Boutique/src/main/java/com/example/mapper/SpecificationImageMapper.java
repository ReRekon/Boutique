package com.example.mapper;

import com.example.entity.SpecificationImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationImageMapper {

    int add(SpecificationImage specificationImage);

    int delete(int specificationImageId);

    int update(SpecificationImage specificationImage);

    List<SpecificationImage> findAll(int productId);
}
