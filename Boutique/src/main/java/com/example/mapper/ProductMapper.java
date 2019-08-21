package com.example.mapper;

import com.example.entity.Product;
import com.example.entity.ProductImage;
import com.example.vo.ProductVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    //通过一级分类查询商品，返回一个List
     List<ProductVo> queryProductByProductType1(int c_id);

    //通过一级分类下的二级分类查商品，返回一个List
     List<ProductVo> queryProductByProductType2(int c_id2);

    //查询一个商品的所有图片，返回一个List
     List<ProductImage> queryImageByProduct(int p_id);

    //按焦点图的商品
    List<ProductVo> queryFocusProduct(int t);
}













