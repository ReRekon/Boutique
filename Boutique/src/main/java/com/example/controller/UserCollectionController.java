package com.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserCollection;
import com.example.service.UserCollections;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/usercollection")
public class UserCollectionController {
    @Autowired
    private UserCollections userCollections;

    @RequestMapping("/save/usercollection")
    public Boolean saveUserCollection(UserCollection userCollection) {
        userCollection.setEnterTime(new Date());
        return userCollections.saveUserCollection(userCollection);
    }

    @RequestMapping("/del/usercollection/{id}")
    public Boolean delUserCollection(@PathVariable  int id) {
        return userCollections.delUserCollection(id);
    }

    @RequestMapping("/list/usercollection/{id}")
    public Object listUserCollection(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "size", defaultValue = "10") int size,
                                     @PathVariable int id) {

        PageHelper.startPage(page, size);
        List<UserCollection> listUserCollection = userCollections.listUserCollection(id);
        PageInfo<UserCollection> pageInfo = new PageInfo<>(listUserCollection);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return data.toString();
    }
}
