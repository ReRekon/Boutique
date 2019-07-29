package com.example.entity;

public class AdminBankCard {
    private int userBankcardId;
    private int userId;
    private String type;
    private String number;

    public int getUserBankcardId() {
        return userBankcardId;
    }

    public void setUserBankcardId(int userBankcardId) {
        this.userBankcardId = userBankcardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
