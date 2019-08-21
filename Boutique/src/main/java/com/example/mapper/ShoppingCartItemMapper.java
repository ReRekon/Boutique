package com.example.mapper;


import com.example.entity.Product;
import com.example.entity.ShoppingCart;
import com.example.entity.ShoppingCartItem;
import org.apache.ibatis.annotations.Param;
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
    int updataNumByGid(@Param("id") int id,@Param("num") Long num,@Param("totalprice") BigDecimal totalprice,@Param("finalprice") BigDecimal finalprice);


    //通过购物项id删除对应的购物项
    void deleteByGid(int id);

    //通过商品id查到商品表里面的图
    String findPictureByPid(int id);

    //通过用户输入的模糊商品名查到所有的商品
    List<Product> findProductsByName(String name);

    //检验一个用户是否只是一个购物车
    List<ShoppingCart> checkoutShopCartByUid(int id);

    //通过用户输入的商品名，返回有关商品名的列表
    List<String> productNameList(String name);

    //通过商品id查的一个价格
    BigDecimal productpriceByPid(int id);


}
