package com.jk.model;

public class BanxingAndKecheng {
    private String banxingandkechengid;//主键id
    private String banxingid;//班型id
    private String kechengid;//课程id

    public String getBanxingandkechengid() {
        return banxingandkechengid;
    }

    public void setBanxingandkechengid(String banxingandkechengid) {
        this.banxingandkechengid = banxingandkechengid;
    }

    public String getBanxingid() {
        return banxingid;
    }

    public void setBanxingid(String banxingid) {
        this.banxingid = banxingid;
    }

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    @Override
    public String toString() {
        return "BanxingAndKecheng{" +
                "banxingandkechengid='" + banxingandkechengid + '\'' +
                ", banxingid='" + banxingid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                '}';
    }
}
