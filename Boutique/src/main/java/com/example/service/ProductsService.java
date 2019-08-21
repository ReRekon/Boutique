package com.example.service;



import com.example.entity.Product;

import com.example.entity.ProductSpecification;

import com.example.vo.Historys;


import java.util.ArrayList;
import java.util.List;



public interface ProductsService {


    //插入历史记录，查询到了删掉之前的，再插入
    public void updateHistory(Integer productId, Integer userId);
    //批量删除历史纪录
    public void deleteSomeHistory(List<Integer> list, Integer userId);
    //返回历史记录
    public ArrayList<Historys> returnAllHistory(Integer userId);
    //返回商品所有图片
      public List<String> returnAllImg(Integer productId);

    public ArrayList<ProductSpecification> returnProductSpecification(Integer productId);
    //返回默认规格和默认价格
    public ProductSpecification returnmorenProductSpecification(Integer productId);
    //返回商品所有信息
    public Product returnProduct(Integer productId);
}
