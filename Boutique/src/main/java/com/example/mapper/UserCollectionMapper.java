package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.entity.UserCollection;

public interface UserCollectionMapper {

    @Insert("INSERT INTO `user_collection` ( `t_id`, `u_id`, `uc_time`, `state`) VALUES"
            + "(#{productId}, #{userId}, #{enterTime}, #{state});")
    @Options(useGeneratedKeys = true, keyProperty = "userCollectionId", keyColumn = "uc_id")
    int save(UserCollection userCollection);

    @Delete("DELETE FROM user_collection WHERE uc_id =#{id}")
    int del(@Param("id") long id);

    @Select("select * from user_collection  WHERE u_id =#{id} ORDER BY uc_time desc")
    @Results(value = { @Result(id = true, property = "userCollectionId", column = "uc_id"),
                       @Result(property = "productId", column = "t_id"),
                       @Result(property = "userId", column = "u_id"),
                       @Result(property = "enterTime", column = "uc_time"),
                       @Result(property = "state", column = "state") })
    List<UserCollection> list(@Param("id") long id);
}
