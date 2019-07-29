package com.example.service;
import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.vo.AdminLoginVo;
import com.example.vo.AdminVo;

import java.util.List;

public interface AdminService {

    //增加admin用户
    public Boolean insertAdmin(Admin admin);

    public  Admin login(AdminLoginVo adminLoginVo);

    public Boolean checkUserName(String name);

    public Boolean insertAdminBankCard(AdminBankCard adminBankCard);

    public Boolean checkTel(String tel);

    public Boolean checkPassword(Admin admin);

    public void updatePassword(Admin admin);

    public List<AdminBankCard> findBankCard(Integer id);

    public Admin selectByTel(String tel);
    public void updateAdmin(AdminVo adminVo);
}