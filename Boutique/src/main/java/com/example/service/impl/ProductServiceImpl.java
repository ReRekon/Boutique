package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.ProductImage;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;
import com.example.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    //查询一个分类的所有商品，返回一个List
    public List<ProductVo> queryProductByProductType1(int c_id) {
        return productMapper.queryProductByProductType1(c_id);
    }

    //通过一级分类下的二级分类查商品
    public List<ProductVo> queryProductByProductType2(int c_id2){
        return productMapper.queryProductByProductType2(c_id2);
    }

    //查询一个商品的所有图片，返回一个List
    public List<ProductImage> queryImageByProduct(int p_id) {
        return productMapper.queryImageByProduct(p_id);
    }

    @Override
    public List<ProductVo> queryFocusProduct(int t) {
        return productMapper.queryFocusProduct(t);
    }
}
