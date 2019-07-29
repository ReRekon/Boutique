package com.example.service;


import com.example.entity.Product;
import com.example.vo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CFService {

    public List<Result> findProductIdAndNumberByAdminId(int userId);

    public List<Product> findGuessYouLike(int productId);

    public List<Integer> resultProductTypeId(int productId);

}
