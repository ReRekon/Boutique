package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.impl.AdminAddressServiceImpl;
import com.example.entity.AdminAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AdminAddressController {

    @Autowired
    private AdminAddressServiceImpl adminAddressServiceImpl;

    @RequestMapping("/toAddress")
    public String toAddress(){
        return "address";
    }

    /**
     * 增加数据
     * @param adminAddress
     * @return
     */
    @RequestMapping("/addAddress")
    @ResponseBody
    public int insert(@Valid AdminAddress adminAddress){
        adminAddressServiceImpl.add(adminAddress);
        //主键回填
        return adminAddress.getUserAddressid();
    }

    /**
     *删除数据
     * @param aid
     * @return
     */
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public int delete(@RequestParam("aid") int aid){
        return adminAddressServiceImpl.delete(aid);
    }

    /**
     * 修改数据
     * @param adminAddress
     * @return
     */
    @RequestMapping("/updateAddress")
    @ResponseBody
    public int update(@Valid AdminAddress adminAddress){

//        System.out.println(adminAddressService.update(adminAddress).getClass().getName()+"------");
//        System.out.println(adminAddressService.update(adminAddress)+"===============");


        return  adminAddressServiceImpl.update(adminAddress);
    }

    /**
     * 根据用户名查询所有地址
     * @param adminAddress
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAddress")
    public String getAderss(@RequestParam("uname") String uname){

        System.out.println("++++++"+uname);
        List<AdminAddress> adminAddressList =adminAddressServiceImpl.findAll(uname);
        return JSONObject.toJSONString(adminAddressList);
//        return adminAddressService.findone(aid).toString();
    }
}
