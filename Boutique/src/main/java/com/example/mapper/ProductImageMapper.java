package com.example.mapper;

import com.example.entity.ProductImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageMapper {

    /**
     * 增加图片
     * @param productImage
     * @return
     */
    int add(ProductImage productImage);

    /**
     * 删除图片
     * @param productImageId
     * @return
     */
    int delete(int productImageId);

    /**
     * 修改图片
     * @param productImage
     * @return
     */
    int update(ProductImage productImage);

    /**
     * 查询图片
     * @param procuctId
     * @return
     */
    List<ProductImage> findAll(int procuctId);
}
