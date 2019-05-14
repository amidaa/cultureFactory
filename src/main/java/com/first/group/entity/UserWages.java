package com.first.group.entity;

public class UserWages {
    private int wageid;

    private String date;
    private String userid;

    private String wages;

    private String reward;

    public int getWageid() {
        return wageid;
    }

    public void setWageid(int wageid) {
        this.wageid = wageid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages == null ? null : wages.trim();
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward == null ? null : reward.trim();
    }
}