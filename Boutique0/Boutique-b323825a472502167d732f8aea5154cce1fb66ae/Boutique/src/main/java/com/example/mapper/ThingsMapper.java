package com.example.mapper;

import com.example.entity.Things;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingsMapper {

    //增加商品信息
   // void addThings(Things things);

//    //删除商品信息
//    void deleteThings(Integer id);
//
//    //修改商品信息
//    void upDate(Things things);
//
//    //通过id查找商品信息
    Things selectThings(Integer id);

}
