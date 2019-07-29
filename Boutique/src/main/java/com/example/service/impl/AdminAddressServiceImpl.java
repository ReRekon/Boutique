package com.example.service.impl;

import com.example.entity.AdminAddress;
import com.example.mapper.AdminAddressMapper;
import com.example.service.AdminAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminAddressServiceImpl implements AdminAddressService {
    @Autowired
    AdminAddressMapper adminAddressMapper;

    /**
     * 增加地址信息
     * @param adminAddress
     * @return adminAddress.getUserAddressid()
     * 根据返回的主键值判断是否添加成功
     */
    public int add(AdminAddress adminAddress){
        return adminAddressMapper.add(adminAddress);
    }

    public int delete(int aid){
        return adminAddressMapper.delete(aid);
    }
    /**
     * 修改地址信息
     * @param adminAddress
     * @return
     * sql条数
     * update  admin_adress set aa_name=#{name},telephone=#{telephone},province=#{province},city=#{city},
     *           area=#{area},street=#{street},aa_adress=#{adress},state=#{state}
     */
    public int update(AdminAddress adminAddress){
        return adminAddressMapper.update(adminAddress);
    }
    /**
     * 查询用户编号为uid的所有地址
     * @param
     * @return
     */
    public List<AdminAddress> findAll(String uname){

        List<AdminAddress> addressList = null;
        addressList = new ArrayList<AdminAddress>();
        addressList = adminAddressMapper.findAll(uname);
        return addressList;
    }
//    public AdminAddress findone(int aid){
//        //System.out.println(adminAddressMapper.findone(aid)+"==================");
//        return adminAddressMapper.findone(aid);
//    }

}
