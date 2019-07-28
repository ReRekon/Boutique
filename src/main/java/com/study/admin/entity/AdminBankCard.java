package com.study.admin.entity;

public class AdminBankCard {
    private Integer id;
    private Integer userId;
    private String type;
    private String number;

    @Override
    public String toString() {
        return "AdminBankCard{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public AdminBankCard() {
    }

    public AdminBankCard(Integer id, Integer userId, String type, String number) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
