package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Product;
import com.example.service.ProductsService;
import com.example.service.impl.ProductsServiceImpl;
import com.example.vo.Historys;
import com.example.vo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductsController
{
    @Autowired
    private ProductsService productsService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    //根据用户id查找对应的历史，返回所有历史商品
    @ResponseBody
    @RequestMapping("/tohistory/{productId}")
    public ArrayList<Historys> returnAllHistory(@PathVariable Integer productId)
    {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
        return productsService.returnAllHistory(productId,userId);
    }
    //根据用户选择的商品id删除历史纪录
    @ResponseBody
    @RequestMapping("/tohistory")
    public String deleteSomeHistory(ArrayList<Integer> list )
    {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
        return JSONObject.toJSONString( productsService.deleteSomeHistory(list,userId));
    }

    //商品id返回折后价
    @ResponseBody
    @RequestMapping("/todiscountprice/{productId}/{productSpecificationId}")
    public BigDecimal returnDiscountPrice(@PathVariable Integer productId,
                                      @PathVariable Integer productSpecificationId
                                      )
    {
        return productsService.returnDiscountPrice(productId,productSpecificationId);
    }
    //返回商品原价
    @ResponseBody
    @RequestMapping("/toprice/{productSpecificationId}")
    public BigDecimal returnPrice(@PathVariable Integer productSpecificationId)
    {
        return productsService.returnPrice(productSpecificationId);
    }

   //商品id返回商品信息
   @ResponseBody
   @RequestMapping("/product/{productId}")
   public Products returnProduct(@PathVariable Integer productId)
   {

       return productsService.returnProduct(productId);
   }
}
