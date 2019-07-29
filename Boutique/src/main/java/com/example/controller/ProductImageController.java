package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.ProductImage;

import com.example.service.impl.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/productImage")
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    /**
     * 增加图片
     * 可增加一步判断，返回字串表示成功或失败
     * @param productImage
     * @return
     */
    @RequestMapping("/addProductImage")
    @ResponseBody
    public int add(@Valid ProductImage productImage){
        productImageService.add(productImage);
        //主键回填
        return productImage.getProductImageId();
    }

    /**
     * 删除图片
     * 可增加一步判断，返回字串表示成功或失败
     * @param productImageId
     * @return
     */
    @RequestMapping("/deleteProductImage")
    @ResponseBody
    public int delete(@RequestParam("productImageId") int productImageId){
        return productImageService.delete(productImageId);
    }

    /**
     * 修改图片
     * 可增加一步判断，返回字串表示成功或失败
     * @param productImage
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateProductImage")
    public int update(@Valid ProductImage productImage){
        return productImageService.update(productImage);
    }

    /**
     * 查询图片
     * 可增加一步判断，返回字串表示成功或失败
     * @param productImageId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getProductImage")
    public String getImg(@RequestParam("productImageId") int productImageId){
        List<ProductImage> productImageList = productImageService.findAll(productImageId);
        return JSONObject.toJSONString(productImageList);
    }
}
