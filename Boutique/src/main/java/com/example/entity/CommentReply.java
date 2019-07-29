package com.example.entity;

public class CommentReply {
    private int replyId;
    private int commentId;
    private String ReplyConnect;
    private String replyTime;

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
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }
}
