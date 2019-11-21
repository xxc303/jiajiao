package com.bysj.pojo;

import java.util.Date;

/**
 * @author 123
 */
public class Evalution {
    private int id;
    private Date postTime;
    private Date anTime;
    private String postContent;
    private String anContent;
    private int orderId;
    private int toUser;
    private int toTeacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Date getAnTime() {
        return anTime;
    }

    public void setAnTime(Date anTime) {
        this.anTime = anTime;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getAnContent() {
        return anContent;
    }

    public void setAnContent(String anContent) {
        this.anContent = anContent;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getToUser() {
        return toUser;
    }

    public void setToUser(int toUser) {
        this.toUser = toUser;
    }

    public int getToTeacher() {
        return toTeacher;
    }

    public void setToTeacher(int toTeacher) {
        this.toTeacher = toTeacher;
    }
}
