package com.yue.waimaiserver.api.entity;

public class WaimaiUser {
    private Integer id;

    private String userName;

    private String poseition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPoseition() {
        return poseition;
    }

    public void setPoseition(String poseition) {
        this.poseition = poseition == null ? null : poseition.trim();
    }
}