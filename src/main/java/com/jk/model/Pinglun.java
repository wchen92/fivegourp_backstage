package com.jk.model;

import java.util.Date;

public class Pinglun {
    private String pinglunid;//                  评论id
    private String yonghuid;//                    用户id
    private String neirong;//                      内容
    private Date chuangjiandate;//                 创建时间
    private String kechengid ;//                     课程id

    public String getPinglunid() {
        return pinglunid;
    }

    public void setPinglunid(String pinglunid) {
        this.pinglunid = pinglunid;
    }

    public String getYonghuid() {
        return yonghuid;
    }

    public void setYonghuid(String yonghuid) {
        this.yonghuid = yonghuid;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public Date getChuangjiandate() {
        return chuangjiandate;
    }

    public void setChuangjiandate(Date chuangjiandate) {
        this.chuangjiandate = chuangjiandate;
    }

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    @Override
    public String toString() {
        return "Pinglun{" +
                "pinglunid='" + pinglunid + '\'' +
                ", yonghuid='" + yonghuid + '\'' +
                ", neirong='" + neirong + '\'' +
                ", chuangjiandate=" + chuangjiandate +
                ", kechengid='" + kechengid + '\'' +
                '}';
    }
}
