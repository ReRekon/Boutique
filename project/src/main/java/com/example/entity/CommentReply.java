package com.example.entity;

import lombok.Data;

@Data
public class CommentReply {
    private int replyId;
    private int commentId;
    private String replyConnect;
    private String replyTime;
}
