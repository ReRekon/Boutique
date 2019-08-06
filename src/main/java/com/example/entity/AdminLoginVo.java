package com.example.entity;


public class AdminLoginVo {
    private String name;
    private String password;
    public AdminLoginVo() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminLoginVo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public AdminLoginVo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
