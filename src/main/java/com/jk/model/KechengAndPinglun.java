package com.jk.model;

public class KechengAndPinglun {
    private String kechengandpinglunid;//课程和评论id
    private String kechengid;//课程id
    private String pinglunid;//评论id

    public String getKechengandpinglunid() {
        return kechengandpinglunid;
    }

    public void setKechengandpinglunid(String kechengandpinglunid) {
        this.kechengandpinglunid = kechengandpinglunid;
    }

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    public String getPinglunid() {
        return pinglunid;
    }

    public void setPinglunid(String pinglunid) {
        this.pinglunid = pinglunid;
    }

    @Override
    public String toString() {
        return "KechengAndPinglun{" +
                "kechengandpinglunid='" + kechengandpinglunid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                ", pinglunid='" + pinglunid + '\'' +
                '}';
    }
}
