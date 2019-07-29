package com.example.service.impl;

import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.mapper.AdminMapper;
import com.example.service.AdminService;
import com.example.vo.AdminLoginVo;
import com.example.vo.AdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;



    @Override
    public Boolean insertAdmin(Admin admin) {
        Integer i = adminMapper.insertAdmin(admin);
        return i>0?true:false;
    }

    @Override
    public Admin login(AdminLoginVo adminLoginVo) {
        return adminMapper.login(adminLoginVo);
    }

    @Override
    public Boolean checkUserName(String name) {
        Integer i = adminMapper.checkUserName(name);
        return i>0?true:false;
    }

    @Override
    public Boolean insertAdminBankCard(AdminBankCard adminBankCard) {
        Integer i = adminMapper.insertAdminBankCard(adminBankCard);
        return i>0?true:false;
    }

    @Override
    public Boolean checkTel(String tel) {
        Integer i = adminMapper.checkTel(tel);
        return i>0?true:false;
    }

    @Override
    public Boolean checkPassword(Admin admin) {
        Integer i = adminMapper.checkPassword(admin);
        return i>0?true:false;
    }

    @Override
    public void updatePassword(Admin admin) {
        adminMapper.updatePassword(admin);
    }

    @Override
    public List<AdminBankCard> findBankCard(Integer id) {
        return adminMapper.findBankCard(id);
    }

    @Override
    public Admin selectByTel(String tel) {
        return adminMapper.selectByTel(tel);
    }


    @Override
    public void updateAdmin(AdminVo adminVo) {
        adminMapper.updateAdmin(adminVo);
    }

}
