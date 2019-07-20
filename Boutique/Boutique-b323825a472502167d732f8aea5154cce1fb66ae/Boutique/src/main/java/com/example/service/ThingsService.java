package com.example.service;

import com.example.entity.Things;
import com.example.entity.User;
import com.example.mapper.ThingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThingsService {
    @Autowired
    ThingsMapper thingsMapper;

    public Things selectThings(Integer id)
    {
        return thingsMapper.selectThings(id);
    }
}
