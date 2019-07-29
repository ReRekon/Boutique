package com.example.mapper;

import com.example.entity.FocusImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FocusImageMapper {

    //查询焦点图
     List<FocusImage> queryFocusImage();
}

















