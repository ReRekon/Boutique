package com.example.service;


import com.example.entity.History;
import com.example.entity.Product;

import com.example.entity.ProductSpecification;
import com.example.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public interface ProductsService {

    public Product selectProduct(Integer productId);

    //插入历史记录，查询到了删掉之前的，再插入
    public void updateHistory(Integer productId, Integer userId);
    //批量删除历史纪录
    public  ArrayList<Product> deleteSomeHistory(List<Integer> list, Integer userId);
    public ArrayList<Product> returnAllHistory(Integer productId, Integer userId);
    //返回商品所有图片
      public ArrayList<String> returnAllImg(Integer productId);
      //返回商品折后价
      public BigDecimal returnDiscountPrice(Integer productId, Integer productSpecificationId);
      //返回商品原价
      public BigDecimal returnPrice(Integer productSpecificationId);
    //根据商品id返回规格id，描述
    public ArrayList<ProductSpecification> returnProductSpecification(Integer productId);
    //返回默认规格和默认价格
    public ProductSpecification returnmorenProductSpecification(Integer productId);
}
