package com.example.vo;

import java.util.Date;

public class AdminVo {
    private int userId;
    private String name;
    private String imageURL;
    private String email;
    private String signature;
    private String tel;
    private long vip;
    private Date createtime;
    public AdminVo() {
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", email='" + email + '\'' +
                ", signature='" + signature + '\'' +
                ", tel='" + tel + '\'' +
                ", vip=" + vip +
                ", createtime=" + createtime +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getVip() {
        return vip;
    }

    public void setVip(long vip) {
        this.vip = vip;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public AdminVo(int userId, String name, String imageURL, String email, String signature, String tel, long vip, Date createtime) {
        this.userId = userId;
        this.name = name;
        this.imageURL = imageURL;
        this.email = email;
        this.signature = signature;
        this.tel = tel;
        this.vip = vip;
        this.createtime = createtime;
    }
}
