package com.example.entity;

import java.util.Date;

public class Admin {
    private int id;
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

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", signature='" + signature + '\'' +
                ", tel='" + tel + '\'' +
                ", vip=" + vip +
                ", state=" + state +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Admin() {
    }

    public Admin(int id, String name, String imageURL, String password, String email, String signature, String tel, long vip, int state, Date createtime, Date updatetime) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.password = password;
        this.email = email;
        this.signature = signature;
        this.tel = tel;
        this.vip = vip;
        this.state = state;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }
}
