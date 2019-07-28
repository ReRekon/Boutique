package com.example.entity;

import lombok.Data;

@Data
public class Comment {
    private int commentId;
    private int productId;
    private int orderId;
    private int userId;
    private String imageURL;
    private String description;
    private String time;
    private int fatherId;
    private int star;
    private int state;
}
