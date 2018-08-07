package com.jk.model;

public class BanXing {
    private String banxingid ;
    private String  banxingname;

    public String getBanxingid() {
        return banxingid;
    }

    public void setBanxingid(String banxingid) {
        this.banxingid = banxingid;
    }

    public String getBanxingname() {
        return banxingname;
    }

    public void setBanxingname(String banxingname) {
        this.banxingname = banxingname;
    }

    @Override
    public String toString() {
        return "BanXing{" +
                "banxingid='" + banxingid + '\'' +
                ", banxingname='" + banxingname + '\'' +
                '}';
    }
}
