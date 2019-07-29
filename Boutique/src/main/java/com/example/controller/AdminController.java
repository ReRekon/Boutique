package com.example.controller;

import com.example.entity.Admin;
import com.example.entity.AdminBankCard;
import com.example.service.AdminService;
import com.example.service.impl.SmsServiceImpl;
import com.example.vo.AdminLoginVo;
import com.example.vo.AdminVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 用户
 */
@Controller
@RequestMapping("/admin")
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


    //注册
    @RequestMapping(value = "/register")
    public String register(@RequestParam(name = "name") String name,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "tel") String tel) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        admin.setTel(tel);
        admin.setCreatetime(new Date());
        admin.setState(1);
        Boolean b = adminService.insertAdmin(admin);
        if (b) {
            //跳转到注册成功页面
            return "success";
        } else {
            //跳转到注册失败的页面
            return "false";
        }
    }

    /**
     * 后台获得验证码
     */
    @RequestMapping("/getCode")
    @ResponseBody
    public int getcode(String tel) {
        long l=System.currentTimeMillis();
        int k1=(int) (l%10000);
        String code=String.valueOf(k1);
        //session中保存我后台生成的code,为了将来拿出来与用户提交的进行比较。
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("code",code);
        //成功返回1，失败返回0
        if(tel!=null){
            //把后台生成的code和所发送的手机号传进发送消息类，调用执行。
            SmsServiceImpl.send(tel,code);
            return 0;
        }else{
            return 1;
        }
    }
    /**
     *判断验证码的正确性
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public int authorization(String preauthcode) {
        HttpSession session = httpServletRequest.getSession();
        String code= (String) session.getAttribute("autocode");
        //验证码不为空时，到后台进行比较，返回响应码，为1，提示请先获得验证码
        //为2，提示验证码错误
        //为3，验证码正确，无提示
        if(code==null){
            return 1;
        }else if(code.equals(preauthcode)){
            return 3;
        }else{
            return 2;
        }
    }

    //测试
    @RequestMapping(value = "/aaa")
    public String aaa() {
        return "test";
    }

    //登陆
    @RequestMapping(value = "/login")
    public String login(@Valid AdminLoginVo adminLoginVo) {
        Admin admin = null;
        try {
            admin = adminService.login(adminLoginVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (admin != null && admin.getState() == 1) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("admin", getAdminVo(admin));
            //跳转到首页
            return "success";
        }else {
            //跳转到登陆页面  提示用户名或者密码错误
            return "false";
        }
    }

    //校验用户名是否存在
    @RequestMapping(value = "/checkUserName")
    @ResponseBody
    public Boolean checkUserName(@RequestParam String name) {
        Boolean aBoolean = adminService.checkUserName(name);
        //返回boolean 的json
        return aBoolean;
    }

    //退出登录
    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout() {
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("admin");
        //转到首页
        return "";
    }


    //增加银行卡信息
    @RequestMapping(value = "/addBankCard")
    public String addBankCard(@RequestParam String type, @RequestParam String number) {
        HttpSession session = httpServletRequest.getSession();
        AdminVo adminVo = (AdminVo) session.getAttribute("admin");
        AdminBankCard adminBankCard = new AdminBankCard();
        adminBankCard.setUserId(adminVo.getUserId());
        adminBankCard.setType(type);
        adminBankCard.setNumber(number);
        Boolean b = adminService.insertAdminBankCard(adminBankCard);
        if (b) {
            //返回添加成功界面
            return "success";
        } else {
            //返回添加失败界面
            return "false";
        }
    }

    //校验手机号是否被占用
    @RequestMapping(value = "/checkTel")
    @ResponseBody
    public Boolean checkEmail(@RequestParam String tel) {
        Boolean aBoolean = adminService.checkTel(tel);
        //返回boolean 的json
        return aBoolean;
    }

    //修改密码
    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestParam String opassword, @RequestParam String npassword) {
        AdminVo adminVo = (AdminVo) httpServletRequest.getSession().getAttribute("admin");
        Admin admin = new Admin();
        admin.setName(adminVo.getName());
        admin.setPassword(opassword);
        Boolean o = adminService.checkPassword(admin);
        if (o) {
            admin.setPassword(npassword);
            adminService.updatePassword(admin);
            //返回成功的页面
            return "success";
        } else {
            //返回失败的页面
            return "false";
        }
    }

    //忘记密码
    @RequestMapping("/forgetPassword")
    public String findPassword(String tel,String password) {
        Admin admin = adminService.selectByTel(tel);
        admin.setPassword(password);
        if (admin == null) {
            return "false";
        } else {
            adminService.updatePassword(admin);
            return "success";
        }
    }
    //查找所有银行卡信息
    @RequestMapping("/findBankCard")
    @ResponseBody
    public List<AdminBankCard> findBankCard() {
        HttpSession session = httpServletRequest.getSession();
        AdminVo adminVo = (AdminVo) session.getAttribute("admin");
        Integer id = adminVo.getUserId();
        List<AdminBankCard> adminBankCards = adminService.findBankCard(id);
        return adminBankCards;
    }
    //修改用户信息
    @RequestMapping("/updateAdmin")
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

}
