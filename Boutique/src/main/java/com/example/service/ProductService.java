package com.example.service;

import com.example.entity.Product;
import com.example.entity.ProductImage;

import java.util.List;

public interface ProductService {



    //查询一个分类的所有商品，返回一个List
     List<Product> queryProductByProductType1(int c_id);

    //通过一级分类下的二级分类查商品
     List<Product> queryProductByProductType2(int c_id2);

    //查询一个商品的所有图片，返回一个List
     List<ProductImage> queryImageByProduct(int p_id);


}
