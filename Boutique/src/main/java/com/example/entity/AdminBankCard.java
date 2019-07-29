package com.example.entity;

public class AdminBankCard {
    private int userBankcardId;
    private int userId;
    private String type;
    private String number;

    public AdminBankCard() {
    }

    @Override
    public String toString() {
        return "AdminBankCard{" +
                "userBankcardId=" + userBankcardId +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

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

    public AdminBankCard(int userBankcardId, int userId, String type, String number) {
        this.userBankcardId = userBankcardId;
        this.userId = userId;
        this.type = type;
        this.number = number;
    }
}
