package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {
    private int userId;
    private String name;
    private String imageURL;
    private String password;
    private String email;
    private String signature;
    private String tel;
    private long vip;
    private int state;
    private Date createtime;
    private Date updatetime;
    private String otpcode;
}
