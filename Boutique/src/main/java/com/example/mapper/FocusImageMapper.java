package com.example.mapper;

import com.example.entity.FocusImage;
import com.example.vo.ProductVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FocusImageMapper {

    //查询焦点图
     List<FocusImage> queryFocusImage();

     //焦点图按进去之后
    List<ProductVo> queryFoucusProduct();
}

















