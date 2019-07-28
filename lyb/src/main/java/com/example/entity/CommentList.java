package com.example.entity;

import lombok.Data;

@Data
public class CommentList {
    private String  userPic;
    private String  userName;
    private String  commentTime;
    private String  articleType;
    private String  commentContent;
    private String  articlePic;
}