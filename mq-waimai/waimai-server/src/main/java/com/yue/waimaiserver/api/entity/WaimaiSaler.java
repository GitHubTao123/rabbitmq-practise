package com.yue.waimaiserver.api.entity;

public class WaimaiSaler {
    private Integer id;

    private String salerName;

    private String poseition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName == null ? null : salerName.trim();
    }

    public String getPoseition() {
        return poseition;
    }

    public void setPoseition(String poseition) {
        this.poseition = poseition == null ? null : poseition.trim();
    }
}