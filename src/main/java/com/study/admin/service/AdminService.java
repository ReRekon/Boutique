package com.study.admin.service;


import com.study.admin.entity.Admin;
import com.study.admin.entity.AdminBankCard;
import com.study.admin.entity.AdminLoginVo;
import com.study.admin.entity.AdminVo;

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

    public List<AdminBankCard> findBankCard( Integer id);

    public Admin selectByTel(String tel);



    void updateAdmin(AdminVo adminVo);
}