package com.example.mapper;

import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.vo.AdminLoginVo;
import com.example.vo.AdminVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {


    public Integer insertAdmin(Admin admin);

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
