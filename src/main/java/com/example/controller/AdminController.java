package com.example.controller;

import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.entity.AdminLoginVo;
import com.example.entity.AdminVo;
import com.example.error.BusinessException;
import com.example.error.EmBusinessError;
import com.example.response.CommonReturnType;
import com.example.service.AdminService;
import com.example.service.Impl.SmsServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
@CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    public AdminVo getAdminVo(Admin admin) {
        if (admin == null) {
            return null;
        }
        AdminVo adminVo = new AdminVo();
        BeanUtils.copyProperties(admin, adminVo);
        return adminVo;
    }
    public String EncodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    //注册
    @RequestMapping(value = "/register")
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "name") String name,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "tel") String tel,
                           @RequestParam(name = "code") String code) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String rCode = (String) this.httpServletRequest.getSession().getAttribute(tel);
        if(!rCode.equals(code)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"短信验证码有误");
        }
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(this.EncodeByMD5(password));
        admin.setTel(tel);
        admin.setCreatetime(new Date());
        admin.setState(1);
        adminService.insertAdmin(admin);
        return CommonReturnType.create(null);
    }

    /**
     * 后台获得验证码
     */
    @PostMapping("/getCode")
    @ResponseBody
    public CommonReturnType getcode(@RequestParam String tel) throws BusinessException {
        long l=System.currentTimeMillis();
        int k1=(int) (l%10000);
        String code=String.valueOf(k1);
        //把后台生成的code和所发送的手机号传进发送消息类，调用执行。
        SmsServiceImpl.send(tel,code);
        //session中保存我后台生成的code,为了将来拿出来与用户提交的进行比较。
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(tel,code);
        return CommonReturnType.create(null);
    }
    //登陆
    @RequestMapping(value = "/login")
    @ResponseBody
    public CommonReturnType login(@RequestParam String name,@RequestParam String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        AdminLoginVo adminLoginVo = new AdminLoginVo();
        adminLoginVo.setName(name);
        adminLoginVo.setPassword(this.EncodeByMD5(password));
        if(StringUtils.isEmpty(adminLoginVo.getName())||
                StringUtils.isEmpty(adminLoginVo.getPassword())){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
         Admin   admin = adminService.login(adminLoginVo);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("admin", getAdminVo(admin));
        return CommonReturnType.create(null);
    }

    //校验用户名是否存在
    @RequestMapping(value = "/checkUserName")
    @ResponseBody
    public CommonReturnType checkUserName(@RequestParam String name) throws BusinessException {
        adminService.checkUserName(name);
        //返回boolean 的json
        return CommonReturnType.create(null);
    }

    //退出登录
    @RequestMapping(value = "/logout")
    @ResponseBody
    public CommonReturnType logout() {
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("admin");
        return CommonReturnType.create(null);
    }


    //增加银行卡信息
    @RequestMapping(value = "/addBankCard")
    @ResponseBody
    public CommonReturnType addBankCard(@RequestParam String type, @RequestParam String number) {
        HttpSession session = httpServletRequest.getSession();
        AdminVo adminVo = (AdminVo) session.getAttribute("admin");
        AdminBankCard adminBankCard = new AdminBankCard();
        adminBankCard.setId(adminVo.getId());
        adminBankCard.setType(type);
        adminBankCard.setNumber(number);
        adminService.insertAdminBankCard(adminBankCard);
        return CommonReturnType.create(null);
    }

    //校验手机号是否被占用
    @RequestMapping(value = "/checkTel")
    @ResponseBody
    public CommonReturnType checkEmail(@RequestParam String tel) throws BusinessException {
        adminService.checkTel(tel);
        return CommonReturnType.create(null);
    }

    //修改密码
    @RequestMapping("/updatePassword")
    @ResponseBody

    public CommonReturnType updatePassword(@RequestParam String opassword, @RequestParam String npassword) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException {
        AdminVo adminVo = (AdminVo) httpServletRequest.getSession().getAttribute("admin");
        Admin admin = new Admin();
        admin.setName(adminVo.getName());
        admin.setPassword(EncodeByMD5(opassword));
        adminService.checkPassword(admin);
        admin.setPassword(EncodeByMD5(npassword));
        adminService.updatePassword(admin);
        return CommonReturnType.create(null);
    }

    //忘记密码
    @RequestMapping("/forgetPassword")
    @ResponseBody
    public CommonReturnType findPassword(@RequestParam String tel,@RequestParam String password,
                                         @RequestParam String code) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String rCode = (String) this.httpServletRequest.getSession().getAttribute(tel);
        if(!rCode.equals(code)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"短信验证码有误");
        }
        Admin admin = adminService.selectByTel(tel);
        admin.setPassword(EncodeByMD5(password));
        adminService.updatePassword(admin);
        return CommonReturnType.create(null);
    }
    //查找所有银行卡信息
    @RequestMapping("/findBankCard")
    @ResponseBody
    public CommonReturnType findBankCard() {
        HttpSession session = httpServletRequest.getSession();
        AdminVo adminVo = (AdminVo) session.getAttribute("admin");
        Integer id = adminVo.getId();
        List<AdminBankCard> adminBankCards = adminService.findBankCard(id);
        return CommonReturnType.create(adminBankCards);
    }
    //修改用户信息
    @RequestMapping("/updateAdmin")
    @ResponseBody

    public void updateAdmin(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam String signature,
                            @RequestParam String tel) {
        HttpSession session = httpServletRequest.getSession();
        AdminVo adminVo = (AdminVo) session.getAttribute("admin");
        adminVo.setName(name);
        adminVo.setEmail(email);
        adminVo.setSignature(signature);
        adminVo.setTel(tel);
        adminService.updateAdmin(adminVo);
        session.setAttribute("admin", adminVo);
    }
    //定义exceptionhandle解决未被controller吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request,Exception ex){
        Map<String,Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex ;
            responseData.put("errCode",businessException.getErrorCode());
            responseData.put("errMsg",businessException.getErrorMsg());
        }else {
            responseData.put("errCode", EmBusinessError.UNKONWN_ERROR.getErrorCode());
            responseData.put("errMsg",EmBusinessError.UNKONWN_ERROR.getErrorMsg());
        }
        return CommonReturnType.create(responseData,"false");
    }
}
