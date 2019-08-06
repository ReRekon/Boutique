package com.example.mapper;

import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.entity.AdminLoginVo;
import com.example.entity.AdminVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {


    public void insertAdmin(Admin admin);

    public Admin login(AdminLoginVo adminLoginVo);

    public Integer checkUserName(String name);

    public Integer insertAdminBankCard(AdminBankCard adminBankCard);

    public Integer checkTel(String tel);

    public Integer checkPassword(Admin admin);

    public void updatePassword(Admin admin);

    public List<AdminBankCard> findBankCard(Integer id);

    public Admin selectByTel(String tel);



    void updateAdmin(AdminVo adminVo);
}
