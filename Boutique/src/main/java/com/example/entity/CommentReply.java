package com.example.entity;

public class CommentReply {
    private int replyId;
    private int commentId;
    private String ReplyConnect;
    private String ReplyTime;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getReplyConnect() {
        return ReplyConnect;
    }

    public void setReplyConnect(String replyConnect) {
        ReplyConnect = replyConnect;
    }

    public String getReplyTime() {
        return ReplyTime;
    }

    public void setReplyTime(String replyTime) {
        ReplyTime = replyTime;
    }
}
