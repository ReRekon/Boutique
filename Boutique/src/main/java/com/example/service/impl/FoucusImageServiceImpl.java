package com.example.service.impl;

import com.example.entity.FocusImage;
import com.example.mapper.FocusImageMapper;
import com.example.service.FoucusImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoucusImageServiceImpl implements FoucusImageService {

    @Autowired
    private FocusImageMapper focusImageMapper;

    public List<FocusImage> queryFocusImage(){
        return focusImageMapper.queryFocusImage();
    }

}
