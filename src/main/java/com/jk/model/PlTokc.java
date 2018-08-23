package com.jk.model;

import java.util.Date;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/21 17:53
 * @ Description：
 * @ Version:
 */
public class PlTokc {
    private String id;
    private String kcid;
    private String pinlun;
    private String userid;
    private Date time;
    private String zhaopian;
    private String getdate;

    public String getGetdate() {
        return getdate;
    }

    public void setGetdate(String getdate) {
        this.getdate = getdate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getZhaopian() {
        return zhaopian;
    }

    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKcid() {
        return kcid;
    }

    public void setKcid(String kcid) {
        this.kcid = kcid;
    }

    public String getPinlun() {
        return pinlun;
    }

    public void setPinlun(String pinlun) {
        this.pinlun = pinlun;
    }

    @Override
    public String toString() {
        return "PlTokc{" +
                "id='" + id + '\'' +
                ", kcid='" + kcid + '\'' +
                ", pinlun='" + pinlun + '\'' +
                ", userid='" + userid + '\'' +
                ", time=" + time +
                ", zhaopian='" + zhaopian + '\'' +
                '}';
    }
}
