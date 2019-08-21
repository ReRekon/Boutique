package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Product;
import com.example.entity.ProductImage;
import com.example.service.impl.ProductServiceImpl;
import com.example.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    //通过一级分类查询商品，返回一个List
    @RequestMapping("/getProductByType1/")
    @ResponseBody
    public String getProductByType(@RequestBody int c_id)
    {

        List<ProductVo> productListAll =  productServiceImpl.queryProductByProductType1(c_id);
        //List<Product> productList = null;

        //如果没有库存，则修改状态
        for (ProductVo product : productListAll) {
            if(0 == product.getInventory())
            {
               product.setState(0);
            }
        }

        return JSONObject.toJSONString(productListAll);
    }


    //查一级分类下二级分类的商品
    @RequestMapping("/getProductByType2")
    @ResponseBody
    public String queryProductByProductType2(@RequestBody int c_id2)
    {

        List<ProductVo> productListAll =  productServiceImpl.queryProductByProductType2(c_id2);
        //List<Product> productList = null;

        //如果没有库存，则修改状态
        for (ProductVo product : productListAll) {
            if(0 == product.getInventory())
            {
                product.setState(0);
            }
        }

        return JSONObject.toJSONString(productListAll);
    }


    //查询一个商品的所有图片，返回一个List
    @RequestMapping("/getImageByProduct")
    @ResponseBody
    public String getImageByProduct(@RequestBody int t_id)
    {

        List<ProductImage> productImageList =  productServiceImpl.queryImageByProduct(t_id);

        return JSONObject.toJSONString(productImageList);
    }

    @RequestMapping("/getFocusProduct/")
    @ResponseBody
    public String queryFocusProduct(@RequestBody int t) {

        List<ProductVo> focusProduct = productServiceImpl.queryFocusProduct(t);
        //如果没有库存，则修改状态
        for (ProductVo product : focusProduct) {
            if(0 == product.getInventory())
            {
                product.setState(0);
            }
        }

        return JSONObject.toJSONString(focusProduct);
    }


}
