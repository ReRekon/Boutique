package com.example.mapper;

import com.example.entity.History;
import com.example.entity.Product;
import com.example.entity.ProductSpecification;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository
public interface ProductsMapper {

    //通过id查找商品信息
    Product selectProduct(Integer productId);
    //查找历史记录
    Integer selectHistory(Integer productId, Integer userId);
    //删除历史记录
    void deleteHistory(Integer productId, Integer userId);

    //插入历史纪录
    void insertHistory(History history);
    //找到所有历史商品
   ArrayList<Integer> selectAllHistory(Integer userId);
      ArrayList<String> findAllImg(Integer productId);
    //得到商品折扣
    Float getDiscount(Integer productId);
    //得到商品原价
    BigDecimal getPrice(Integer productSpecificationId);
    //根据规格id返回规格描述和价格
    ArrayList<ProductSpecification> selectProductSpecification(Integer productId);
    //返回默认规格和价格
    ProductSpecification selectmorenProductSpecification(Integer productId);
}
