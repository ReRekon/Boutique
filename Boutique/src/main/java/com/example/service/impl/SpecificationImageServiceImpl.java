package com.example.service.impl;

import com.example.mapper.SpecificationImageMapper;
import com.example.service.SpecificatoinImageService;
import com.example.entity.SpecificationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecificationImageServiceImpl implements SpecificatoinImageService {

    @Autowired
    SpecificationImageMapper specificationImageMapper;

    public int add(SpecificationImage specificationImage){
        return specificationImageMapper.add(specificationImage);
    }

    public int delete(int specificationImageId){
        return specificationImageMapper.delete(specificationImageId);
    }

    public int update(SpecificationImage specificationImage){
        return specificationImageMapper.update(specificationImage);
    }

    public List<SpecificationImage> findAll(int productId){
        List<SpecificationImage> specificationImageList = null;
        specificationImageList = new ArrayList<SpecificationImage>();
        specificationImageList = specificationImageMapper.findAll(productId);
        return specificationImageList;
    }

}
