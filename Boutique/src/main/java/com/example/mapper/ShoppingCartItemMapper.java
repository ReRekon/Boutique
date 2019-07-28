package com.example.mapper;

import com.example.unifyEntity.Product;
import com.example.unifyEntity.ShoppingCart;
import com.example.unifyEntity.ShoppingCartItem;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShoppingCartItemMapper {

   //注册一个用户就生成一个购物车
    void insertCart(ShoppingCart shoppingCart);

   // 查询一个用户购物车里面的所有的商品
    List<ShoppingCartItem> findByUid(int id);


    //通过用户id删除改用户购物车里面的所有东西(清空购物车)
    void deleteByUId(int id);


    //添加购物车项
    void addShopItem(ShoppingCartItem shoppingCartItem);


    //通过商品规格id查得价格
    BigDecimal findPriceBySid(int id);


   // 通过用户id查得用户所对应的购物车
    int findCartByUid(int id);


    //通过商品id查得商品库存
    Long findInventoryByPid(int id);


    //通过商品id查得折扣
    Float findDiscountByPid(int id);


    //通过购物项id修改数量
    int updataNumByGid(int id,Long num,BigDecimal totalprice,BigDecimal finalprice);


    //通过购物项id删除对应的购物项
    void deleteByGid(int id);

    //通过商品id查到商品表里面的图
    String findPictureByPid(int id);

    //通过用户输入的模糊商品名查到所有的商品
    List<Product> findProductsByName(String name);




}
