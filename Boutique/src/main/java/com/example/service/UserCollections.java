package com.example.service;

import java.util.List;

import com.example.entity.UserCollection;

public interface UserCollections {

    public Boolean saveUserCollection(UserCollection userCollection);

    public Boolean delUserCollection(long id);

    public List<UserCollection> listUserCollection(long id);
}
