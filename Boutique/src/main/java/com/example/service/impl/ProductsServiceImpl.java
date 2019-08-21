package com.example.service.impl;


import com.example.entity.History;
import com.example.entity.Product;
import com.example.entity.ProductSpecification;
import com.example.mapper.ProductsMapper;
import com.example.vo.Historys;
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
    private ProductsMapper productsMapper;
    


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
    public void deleteSomeHistory(List<Integer> list,Integer userId)
    {
        Iterator it=list.iterator();
            while (it.hasNext()) {
                Integer id = (Integer) it.next();
                productsMapper.deleteHistory(id, userId);

            }
    }
    //返回历史记录
    public ArrayList<Historys> returnAllHistory(Integer userId)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list = productsMapper.selectAllHistory(userId);
        if(list!=null)
            return returnHistorys(list);
        else return null;
    }
    public ArrayList<Historys> returnHistorys(ArrayList<Integer> list)
    {
        ArrayList<Historys> list1 = new ArrayList<>();
        for (Integer Id:list
            ) {
                if(Id!=null) {
                    Historys historys = new Historys();
                    historys.setImg(productsMapper.selectProduct(Id).getLogo());
                    historys.setName(productsMapper.selectProduct(Id).getName());
                    historys.setPrice(returnmorenProductSpecification(Id).getPrice());
                    list1.add(historys);
                }
            }
            return list1;

    }
    //返回商品所有图片
      public List<String> returnAllImg(Integer productId)
      {
          List<String> stringList=productsMapper.findAllImg(productId);
          return stringList;
      }


    //根据商品id返回规格id，描述
    public ArrayList<ProductSpecification> returnProductSpecification(Integer productId)
    {

        Float discount = productsMapper.selectProduct(productId).getDiscount();
        ArrayList<ProductSpecification> list = productsMapper.selectProductSpecification(productId);
       for (ProductSpecification p:list) {
            BigDecimal nprice = BigDecimal.valueOf(discount).multiply(p.getPrice());
            p.setNprice(nprice);
        }
        return list;
    }
    //返回默认规格
//    public ProductSpecification returnmorenProductSpecification(Integer productId)
//    {
//        return  productsMapper.selectmorenProductSpecification(productId);
//    }
//    //返回商品所有信息
//    public Products returnProduct(Integer productId)
//    {
//        Products products = new Products();
//        products.setPrice(productsMapper.selectmorenProductSpecification(productId).getPrice());
//        products.setProduct(productsMapper.selectProduct(productId));
//        Float discount = products.getProduct().getDiscount();
//        ArrayList<ProductSpecification> list = returnProductSpecification(productId);
//        for (ProductSpecification p:list
//             ) {
//            BigDecimal nprice = BigDecimal.valueOf(discount).multiply(p.getPrice());
//            p.setNprice(nprice);
//        }
//        products.setProductSpecification(list);
//        products.setImg(returnAllImg(productId));
//        return products;
//    }
    public Product returnProduct(Integer productId)
    {
       return productsMapper.selectProduct(productId);
    }
    public ProductSpecification returnmorenProductSpecification(Integer productId)
    {
        return productsMapper.selectmorenProductSpecification(productId);
    }
}
