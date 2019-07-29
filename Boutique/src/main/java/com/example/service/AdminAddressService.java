package com.example.service;

import com.example.entity.AdminAddress;
import com.example.entity.ProductImage;

import java.util.List;

public interface AdminAddressService {

    int add(AdminAddress adminAddress);
    int delete(int aid);
    int update(AdminAddress adminAddress);
    List<AdminAddress> findAll(String uname);
}
