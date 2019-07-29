package com.example.service.impl;

import java.util.List;

import com.example.mapper.UserCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserCollection;
import com.example.service.UserCollections;

@Service
public class UserCollectionImpl implements UserCollections {

    @Autowired
    private UserCollectionMapper userCollectionMapper;

    @Override
    public Boolean saveUserCollection(UserCollection userCollection) {
        int save = userCollectionMapper.save(userCollection);
        return (save == 1) ? true : false;
    }

    @Override
    public Boolean delUserCollection(int id) {
        int del = userCollectionMapper.del(id);
        return (del == 1) ? true : false;
    }

    @Override
    public List<UserCollection> listUserCollection(int id) {

        return userCollectionMapper.list(id);
    }

}
