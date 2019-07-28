package com.example.entity;

import lombok.Data;
@Data
public class Comment {
    private int commentId;
    private int productId;
    private String orderId;
    private int userId;
    private String imageURL;
    private int state;
    private int description;
    private String time;
    private int fatherId;
}
