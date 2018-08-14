package com.jk.model;

public class RenWu {
    private String renwuid;//任务id
    private String  renwuname;//任务名称
    private String  renwuneirong;//任务内容
    private Integer  wanchengstatus;//完成状态
    private String  chuliren;//处理人
    private String  faburen;//发布人

    public String getRenwuid() {
        return renwuid;
    }

    public void setRenwuid(String renwuid) {
        this.renwuid = renwuid;
    }

    public String getRenwuname() {
        return renwuname;
    }

    public void setRenwuname(String renwuname) {
        this.renwuname = renwuname;
    }

    public String getRenwuneirong() {
        return renwuneirong;
    }

    public void setRenwuneirong(String renwuneirong) {
        this.renwuneirong = renwuneirong;
    }

    public Integer getWanchengstatus() {
        return wanchengstatus;
    }

    public void setWanchengstatus(Integer wanchengstatus) {
        this.wanchengstatus = wanchengstatus;
    }

    public String getChuliren() {
        return chuliren;
    }

    public void setChuliren(String chuliren) {
        this.chuliren = chuliren;
    }

    public String getFaburen() {
        return faburen;
    }

    public void setFaburen(String faburen) {
        this.faburen = faburen;
    }

    @Override
    public String toString() {
        return "RenWu{" +
                "renwuid='" + renwuid + '\'' +
                ", renwuname='" + renwuname + '\'' +
                ", renwuneirong='" + renwuneirong + '\'' +
                ", wanchengstatus='" + wanchengstatus + '\'' +
                ", chuliren='" + chuliren + '\'' +
                ", faburen='" + faburen + '\'' +
                '}';
    }
}
