package com.jk.model;

public class BanxingAndKecheng {
    private String banxingandkechengid;
    private String banxingid;
    private String kechengid;

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
