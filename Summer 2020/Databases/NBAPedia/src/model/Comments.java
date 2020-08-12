package model;

import java.util.Date;

public class Comments {
    private int commentId;
    private Users user;
    private Date created;
    private String content;

    public Comments(int commentId, Users user, Date created, String content) {
        this.commentId = commentId;
        this.user = user;
        this.created = created;
        this.content = content;
    }

    public Comments(Users user, Date created, String content) {
        this.user = user;
        this.created = created;
        this.content = content;
    }

    public Comments(Users user, String content) {
        this.user = user;
        this.content = content;
    }

    public Comments() {
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
