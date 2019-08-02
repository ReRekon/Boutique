package com.example.service.impl;


import com.example.entity.History;
import com.example.entity.Product;
import com.example.entity.ProductSpecification;
import com.example.mapper.ProductsMapper;
import com.example.vo.Historys;
import com.example.vo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class ProductsServiceImpl implements com.example.service.ProductsService{
    @Autowired
    ProductsMapper productsMapper;
    

    public Product selectProduct(Integer productId)
    {
        return productsMapper.selectProduct(productId);
    }

    //插入历史记录，查询到了删掉之前的，再插入
    public void updateHistory(Integer productId, Integer userId){
        History history=new History();
        history.setProductId(productId);
        java.util.Date date = new java.util.Date();
        history.setTimes(new Date(date.getTime()));
        history.setUserId(userId);
        if(null==productsMapper.selectHistory(productId,userId))
        {
            productsMapper.insertHistory(history);
        }
        else{
            productsMapper.deleteHistory(productId,userId);
            productsMapper.insertHistory(history);
        }
    }
    //批量删除历史纪录
    public  ArrayList<Historys> deleteSomeHistory(List<Integer> list,Integer userId)
    {
        Iterator it=list.iterator();
        while (it.hasNext())
        {
            Integer id = (Integer)it.next();
            productsMapper.deleteHistory(id,userId);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        list1 = productsMapper.selectAllHistory(userId);
        ArrayList<Historys> list2 = returnHistorys(list1);

        return list2;
    }
    public ArrayList<Historys> returnHistorys(ArrayList<Integer> list)
    {
        ArrayList<Historys> list1 = new ArrayList<>();
        for (Integer Id:list
        ) {
            Historys historys = new Historys();
            historys.setImg(productsMapper.selectProduct(Id).getLogo());
            historys.setName(productsMapper.selectProduct(Id).getName());
            historys.setPrice(returnmorenProductSpecification(Id).getPrice());
            list1.add(historys);
        }
        return list1;

    }
    public ArrayList<Historys> returnAllHistory(Integer productId, Integer userId)
    {
        updateHistory(productId,userId);
        ArrayList<Integer> list = new ArrayList<>();
        list = productsMapper.selectAllHistory(userId);
        ArrayList<Historys> list1 = returnHistorys(list);
        return list1;
    }
    //返回商品所有图片
      public ArrayList<String> returnAllImg(Integer productId)
      {
          return productsMapper.findAllImg(productId);
      }
      //返回商品折后价
      public BigDecimal returnDiscountPrice(Integer productId, Integer productSpecificationId)
      {
          Float discount = productsMapper.getDiscount(productId);
          BigDecimal price = productsMapper.getPrice(productSpecificationId);
          return BigDecimal.valueOf(discount).multiply(price);
      }
      //返回商品原价
      public BigDecimal returnPrice(Integer productSpecificationId)
    {
       return productsMapper.getPrice(productSpecificationId);
    }
    //根据商品id返回规格id，描述
    public ArrayList<ProductSpecification> returnProductSpecification(Integer productId)
    {
        return productsMapper.selectProductSpecification(productId);
    }
    //返回默认规格
    public ProductSpecification returnmorenProductSpecification(Integer productId)
    {
        return  productsMapper.selectmorenProductSpecification(productId);
    }
    //返回商品所有信息
    public Products returnProduct(Integer productId)
    {
        Products products = new Products();
        products.setPrice(productsMapper.selectmorenProductSpecification(productId).getPrice());
        products.setProduct(productsMapper.selectProduct(productId));
        products.setProductSpecification(returnProductSpecification(productId));
        products.setImg(returnAllImg(productId));
        return products;
    }
}
