package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Admin;
import com.example.entity.ShoppingCartItem;
import com.example.service.impl.ShoppingCartItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShoppingCartItemController {

    @Autowired
    ShoppingCartItemServiceImp shoppingCartItemServiceImp;

    @Autowired
    HttpServletRequest request;

    /**
     *通过用户id创建用户对应的购物车
     */
    @RequestMapping("/user/{id}")
    @ResponseBody
    public String getShopCartByUid(@PathVariable int id){

//        HttpSession session=request.getSession();
//        Admin admin=(Admin) session.getAttribute("Admin");
//        int id=admin.getUserId();
        shoppingCartItemServiceImp.addCartByUid(id);
        return "index";
    }

    /**
     *通过用户id查询购物车里面所有的商品
     */

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getShop(@PathVariable int id){

//        HttpSession session=request.getSession();
//        Admin admin=(Admin) session.getAttribute("Admin");
//        int id=admin.getUserId();
        List<ShoppingCartItem> shoppingCartItemList= shoppingCartItemServiceImp.getShoppingCart(id);
        return JSONObject.toJSONString(shoppingCartItemList);
    }


    /**
     * 通过商品id，商品数量，商品规格id，用户id添加对应的购物车项
     */
    @RequestMapping("/add")
   @ResponseBody
//    public String addShop(){
    public String addShop(@RequestParam int productid,@RequestParam int psid,
                          @RequestParam Long num,@RequestParam int id){
//        HttpSession session=request.getSession();
//        Admin admin=(Admin) session.getAttribute("Admin");
//        int id=admin.getUserId();
//        //        获取前端传过来的商品id
//        int productid=Integer.valueOf(request.getParameter("pid"));
////        获取前端传过来的商品数量
//        Long num=Long.valueOf(request.getParameter("num"));
////        获取前端穿过来的商品规格id
//        int psid=Integer.valueOf(request.getParameter("psid"));

        shoppingCartItemServiceImp.addShopItem(productid,psid,num,id);
        return "ok";
    }

//    @RequestMapping("/add")
//    public String addShop(@RequestParam int productid,@RequestParam int psid,
//                          @RequestParam long num,@RequestParam int id){
//        shoppingCartItemService.addShopItem(productid,psid,num,id);
//        return "index";
//    }


//    @RequestMapping("/delG/{id}")
//    public String delGoodsItem(@PathVariable int id){
//
//        shoppingCartItemService.deleteItemByGid(id);
//        return "index";
//    }
//
//    @ResponseBody
//    @RequestMapping("/getImg/{id}")
//    public String getImg(@PathVariable int id){
//        return shoppingCartItemService.getImgByPid(id).toString();
//    }

    /*
    模糊查询中通过商品名字来获取所有商品
     */
    @ResponseBody
    @RequestMapping("/allproducts")
    public String getAllproducts(@RequestParam String name){

//        String name=request.getParameter("name");
//        return shoppingCartItemServiceImp.getAllProductByName(name).toString();
        return JSONObject.toJSONString(shoppingCartItemServiceImp.getAllProductByName(name));
    }

    /*
    通过前端传过来的关于购物车项id的list集合，来删除对应的购物车项
     */
    public void deleteShoppingCartItems(List<Integer> list)
    {
       shoppingCartItemServiceImp.deleteItemByGid(list);
    }


}
