package com.example.controller;

import com.example.entity.Admin;
import com.example.entity.Product;
import com.example.entity.ShoppingCartItem;

import com.example.service.ShoppingCartItemService;
import com.example.vo.ProductInfo;
import com.example.vo.ShopVo;
import com.example.vo.AdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/shop")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ShoppingCartItemController {

    @Autowired
    ShoppingCartItemService shoppingCartItemService;

    @Autowired
    HttpServletRequest request;

    /**
     *通过用户id创建用户对应的购物车
     */
    @PostMapping("/user")
    @ResponseBody
    public String getShopCartByUid(){

        HttpSession session=request.getSession();
        AdminVo admin=(AdminVo) session.getAttribute("admin");
        int id=admin.getUserId();
        shoppingCartItemService.addCartByUid(id);
        return "ok";
    }

    /**
     *通过用户id查询购物车里面所有的商品
     */

    @RequestMapping("/get")
    @ResponseBody
    public String getShop(){

        HttpSession session=request.getSession();
        AdminVo admin=(AdminVo) session.getAttribute("admin");
        int id=admin.getUserId();
        List<ShoppingCartItem> shoppingCartItemList= shoppingCartItemService.getShoppingCart(id);
//        return JSONObject.toJSONString(shoppingCartItemList);
        return shoppingCartItemList.toString();
    }


    /**
     * 通过商品id，商品数量，商品规格id，用户id添加对应的购物车项
     */
    @PostMapping("/add")
   @ResponseBody
    public boolean addShop(@RequestBody ShopVo shopVo){
//    public boolean addShop(@RequestParam int productid,@RequestParam int psid,
//                          @RequestParam Long num,@RequestParam int id){
        HttpSession session=request.getSession();
       AdminVo admin=(AdminVo) session.getAttribute("admin");
        int id=admin.getUserId();
        // 获取前端传过来的商品id
//        int productid=Integer.valueOf(request.getParameter("pid"));
        int productid=Integer.valueOf(shopVo.getProductid());
//        获取前端传过来的商品数量
//        Long num=Long.valueOf(request.getParameter("num"));
        Long num=Long.valueOf(shopVo.getNum());
//        获取前端穿过来的商品规格id
//        int psid=Integer.valueOf(request.getParameter("psid"));
        int psid=Integer.valueOf(shopVo.getPsid());

        return shoppingCartItemService.addShopItem(productid,psid,num,id);

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
    @PostMapping("/allproducts")
    public String getAllproducts(@RequestParam String name){

        List<ProductInfo> productInfos=new ArrayList();
        List<Product> list=new ArrayList();
        list=shoppingCartItemService.getAllProductByName(name);
        System.out.println(list);
            for (Product p:list) {
                ProductInfo productInfo = new ProductInfo();
                System.out.println("***************");
                System.out.println(p.getProductId());
                productInfo.setProductId(p.getProductId());
                productInfo.setDescription(p.getDescription());
                productInfo.setName(p.getName());
                int id=p.getProductId();
                BigDecimal price=shoppingCartItemService.getProductOnePrice(id);
                productInfo.setPrice(price);
                productInfo.setLogo(p.getLogo());
                productInfos.add(productInfo);
            }
        return productInfos.toString();

    }

    /*
    通过前端传过来的关于购物车项id的list集合，来删除对应的购物车项
     */
    @PostMapping("/del")
    @ResponseBody
    public String deleteShoppingCartItems(@RequestParam ArrayList<Integer> list)
    {
        shoppingCartItemService.deleteItemByGid(list);
        return "ok";
    }

    /*
    通过个别商品名，查出所有有关该商品的名字
     */
    @RequestMapping("/namelist")
    @ResponseBody
    public String findProductNameList(@RequestParam String name)
    {
        System.out.println("************");
        System.out.println(name);
        return shoppingCartItemService.getAllProductNameByName(name).toString();
    }


}
