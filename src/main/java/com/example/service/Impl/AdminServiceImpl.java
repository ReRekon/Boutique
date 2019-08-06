package com.example.service.Impl;

import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.entity.AdminLoginVo;
import com.example.entity.AdminVo;
import com.example.error.BusinessException;
import com.example.error.EmBusinessError;
import com.example.mapper.AdminMapper;
import com.example.service.AdminService;
import org.apache.commons.lang3.StringUtils;
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
    @Transactional
    public void insertAdmin(Admin admin) throws BusinessException {
        if(admin==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        if(StringUtils.isEmpty(admin.getName())||
                StringUtils.isEmpty(admin.getPassword())||
                StringUtils.isEmpty(admin.getTel())){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        this.checkUserName(admin.getName());
        this.checkTel(admin.getTel());
         adminMapper.insertAdmin(admin);
    }

    @Override
    public Admin login(AdminLoginVo adminLoginVo) throws BusinessException {
        Admin admin = adminMapper.login(adminLoginVo);
        if(admin==null){
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        if(!StringUtils.equals(admin.getPassword(),adminLoginVo.getPassword())){
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        return admin;
    }

    @Override
    public void checkUserName(String name) throws BusinessException {
        if(name.equals("")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Integer i = adminMapper.checkUserName(name);
        if(i>0){
            throw new BusinessException(EmBusinessError.USER_NAME_SAME);
        }
    }

    @Override
    public void insertAdminBankCard(AdminBankCard adminBankCard) {

        adminMapper.insertAdminBankCard(adminBankCard);

    }

    @Override
    public void checkTel(String tel) throws BusinessException {
        Integer i = adminMapper.checkTel(tel);
        if(i>0){
            throw new BusinessException(EmBusinessError.USER_TEL_SAME);
        }
    }

    @Override
    public void checkPassword(Admin admin) throws BusinessException {
        Integer i = adminMapper.checkPassword(admin);
        if(i==0){
            throw new BusinessException(EmBusinessError.PASSWORD_FAIL);
        }
    }

    @Override
    public void updatePassword(Admin admin) {
        adminMapper.updatePassword(admin);
    }

    @Override
    public List<AdminBankCard> findBankCard(Integer id){
        return adminMapper.findBankCard(id);
    }

    @Override
    public Admin selectByTel(String tel) throws BusinessException {
        Admin admin = adminMapper.selectByTel(tel);
        if(admin==null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        return admin;
    }


    @Override
    public void updateAdmin(AdminVo adminVo) {
        adminMapper.updateAdmin(adminVo);
    }

}
