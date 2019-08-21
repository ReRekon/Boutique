package com.example.service;


import com.example.entity.Product;
import com.example.vo.ProductVo;
import com.example.vo.Result;


import java.util.List;
public interface CFService {

    List<Result> findProductIdAndNumberByAdminId(int userId);

    List<Product> findGuessYouLike(int productId);

    List<Integer> resultProductTypeId(int productId);

    List<ProductVo>  findGuessYouLikes(int productId);

}
