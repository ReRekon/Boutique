package com.example.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zuojh
 * @date 2019/7/26 23:44
 */
public class SessionInterceptor implements WebMvcConfigurer {
    /**
     * 自定义拦截器，添加拦截路径和排除拦截路径
     * addPathPatterns(): 添加需要拦截的路径
     * excludePathPatterns(): 添加不需要拦截的路径
     */

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List list = new ArrayList();
        list.add("/admin/register");
        list.add("/admin/getCode");
        list.add("/admin/login");
        list.add("/admin/checkUserName");
        list.add("/admin/logout");
        list.add("/admin/checkTel");
        list.add("/admin/checkCode");
        list.add("/admin/findPassword");
        list.add("/admin/forgetPassword");
        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/**").excludePathPatterns(list);

    }
}