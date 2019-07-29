package com.example.service.impl;


import com.example.entity.Product;
import com.example.mapper.GuessYouLikesMapper;
import com.example.service.CFService;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CFServiceImpl implements CFService {
    @Autowired
    private GuessYouLikesMapper guessYouLikesMapper;

    public List<Result> findProductIdAndNumberByAdminId(int userId){
        return guessYouLikesMapper.findProductIdAndNumberByAdminId(userId);
    }

    public List<Product> findGuessYouLike(int productId){

        return guessYouLikesMapper.findGuessYouLike(productId);
    }

    public List<Integer> resultProductTypeId(int productId){
        return guessYouLikesMapper.resultProductTypeId(productId);
    }


}
