package com.example.mapper;


import com.example.entity.Product;
import com.example.vo.ProductVo;
import com.example.vo.Result;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GuessYouLikesMapper {
    public List<Result> findProductIdAndNumberByAdminId(int userId);

    public List<Integer> resultProductTypeId(int productId);

    public List<Product> findGuessYouLike(int productId);

    public List<ProductVo> findGuessYouLikes(int productId);
}
