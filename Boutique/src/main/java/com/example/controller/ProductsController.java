package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Product;

import com.example.service.ProductsService;
import com.example.service.impl.ProductsServiceImpl;
import com.example.vo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductsController
{
    @Autowired
    private ProductsServiceImpl productsService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    //根据用户id查找对应的历史，返回所有历史商品
    @ResponseBody
    @RequestMapping("/tohistory/{productId}")
    public String returnAllHistory(@PathVariable Integer productId)
    {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
        ArrayList<Product> list = new ArrayList<>();
        list = productsService.returnAllHistory(productId,userId);
        return  JSONObject.toJSONString(list);
    }
    //根据用户选择的商品id删除历史纪录
    @ResponseBody
    @RequestMapping("/tohistory")
    public String deleteSomeHistory(ArrayList<Integer> list)
    {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
           return JSONObject.toJSONString(productsService.deleteSomeHistory(list,userId));
    }
    //商品id返回所有图片
//    @ResponseBody
//    @RequestMapping("/toimage/{productId}")
//    public String returnAllImg(@PathVariable Integer productId)
//    {
//        ArrayList<String> list = new ArrayList<String>();
//        list=productsService.returnAllImg(productId);
//        return JSONObject.toJSONString(list);
//    }

    //商品id返回折后价
    @ResponseBody
    @RequestMapping("/todiscountprice/{productId}/{productSpecificationId}")
    public String returnDiscountPrice(@PathVariable Integer productId,
                                      @PathVariable Integer productSpecificationId
                                      )
    {
        return JSONObject.toJSONString(productsService.returnDiscountPrice(productId,productSpecificationId));
    }
    //返回商品原价
    @ResponseBody
    @RequestMapping("/toprice/{productSpecificationId}")
    public String returnPrice(@PathVariable Integer productSpecificationId)
    {
        return JSONObject.toJSONString(productsService.returnPrice(productSpecificationId));
    }


    //商品id返回商品详情
//    @ResponseBody
//    @RequestMapping("/toproduct/{productId}")
//    public String returnProduct(@PathVariable Integer productId)
//    {
//        return JSONObject.toJSONString(productsService.selectProduct(productId));
//    }
//
    //根据商品id返回规格id，描述
//    @ResponseBody
//    @RequestMapping("/toguige/{productId}")
//   public String returnProductSpecification(@PathVariable Integer productId)
//   {
//       ArrayList<ProductSpecification> list= new ArrayList<ProductSpecification>();
//       list = productsService.returnProductSpecification(productId);
//       return JSONObject.toJSONString(list);
//   }
   //返回默认价格
//   @ResponseBody
//    @RequestMapping("/product/{productId}")
//    public String returnn(@PathVariable Integer productId)
//   {
//       return JSONObject.toJSONString(productsService.returnmorenProductSpecification(productId));
//   }
   //商品id返回商品信息
   @ResponseBody
   @RequestMapping("/product/{productId}")
   public String returnProduct(@PathVariable Integer productId)
   {
       Products products = new Products();
       products.setPrice(productsService.returnmorenProductSpecification(productId).getPrice());
       products.setProduct(productsService.selectProduct(productId));
       products.setProductSpecification(productsService.returnProductSpecification(productId));
       products.setImg(productsService.returnAllImg(productId));
       return JSONObject.toJSONString(products);
   }
}
