package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Product;
import com.example.entity.ProductImage;
import com.example.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    //通过一级分类查询商品，返回一个List
    @RequestMapping("/getProductByType1/{c_id}")
    @ResponseBody
    public String getProductByType(@PathVariable int c_id)
    {

        List<Product> productListAll =  productServiceImpl.queryProductByProductType1(c_id);
        //List<Product> productList = null;

        //如果没有库存，则修改状态
        for (Product product : productListAll) {
            if(0 == product.getInventory())
            {
               product.setState(0);
            }
        }

        return JSONObject.toJSONString(productListAll);
    }


    //查一级分类下二级分类的商品
    @RequestMapping("/getProductByType2/{c_id2}")
    @ResponseBody
    public String queryProductByProductType2(@PathVariable int c_id2)
    {

        List<Product> productListAll =  productServiceImpl.queryProductByProductType2(c_id2);
        //List<Product> productList = null;

        //如果没有库存，则修改状态
        for (Product product : productListAll) {
            if(0 == product.getInventory())
            {
                product.setState(0);
            }
        }

        return JSONObject.toJSONString(productListAll);
    }


    //查询一个商品的所有图片，返回一个List
    @RequestMapping("/getImageByProduct/{t_id}")
    @ResponseBody
    public String getImageByProduct(@PathVariable int t_id)
    {

        List<ProductImage> productImageList =  productServiceImpl.queryImageByProduct(t_id);

        return JSONObject.toJSONString(productImageList);
    }


}
