package com.example.service;

import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.vo.AdminLoginVo;
import com.example.vo.AdminVo;
import com.example.error.BusinessException;
import java.util.List;
public interface AdminService {

        //增加admin用户
        public void insertAdmin(Admin admin) throws BusinessException;

        public  Admin login(AdminLoginVo adminLoginVo) throws BusinessException;

        public void checkUserName(String name) throws BusinessException;

        public void insertAdminBankCard(AdminBankCard adminBankCard);

        public void checkTel(String tel) throws BusinessException;

        public void checkPassword(Admin admin) throws BusinessException;

        public void updatePassword(Admin admin);

        public List<AdminBankCard> findBankCard( Integer id);

        public Admin selectByTel(String tel) throws BusinessException;
        void updateAdmin(AdminVo adminVo);
}