package com.example.service;

import com.example.entity.Product;
import com.example.entity.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartItemService {

    public void addCartByUid(int id);

    public List<ShoppingCartItem> getShoppingCart(int id);

    public void deleteItemByGid(List<Integer> list);

    public void addShopItem(int productid,int psid,Long num,int id);

    public List<Product> getAllProductByName(String name);



}
