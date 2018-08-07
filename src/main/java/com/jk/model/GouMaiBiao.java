package com.jk.model;

public class GouMaiBiao {
    private String goumaiid;//主键id
    private String kechengid;//课程id
    private String yonghuid;//用户id
    private String goumaishuliang;//购买数量

    public String getGoumaiid() {
        return goumaiid;
    }

    public void setGoumaiid(String goumaiid) {
        this.goumaiid = goumaiid;
    }

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    public String getYonghuid() {
        return yonghuid;
    }

    public void setYonghuid(String yonghuid) {
        this.yonghuid = yonghuid;
    }

    public String getGoumaishuliang() {
        return goumaishuliang;
    }

    public void setGoumaishuliang(String goumaishuliang) {
        this.goumaishuliang = goumaishuliang;
    }

    @Override
    public String toString() {
        return "GouMaiBiao{" +
                "goumaiid='" + goumaiid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                ", yonghuid='" + yonghuid + '\'' +
                ", goumaishuliang='" + goumaishuliang + '\'' +
                '}';
    }
}
