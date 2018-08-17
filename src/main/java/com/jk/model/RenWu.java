package com.jk.model;

public class RenWu {
    private String renwuid;//任务id
    private String  renwuname;//任务名称
    private String  renwuneirong;//任务内容
    private Integer  wanchengstatus;//完成状态
    private String  chulirenid;//处理人
    private String  faburenid;//发布人
    private Integer shifouzhipai;//是否指派  1 已指派 2未指派


    private String   rwid;
    private String  rwmc;
    private String  rwnr;
    private String  clr;
    private Integer  sfzp;
    private Integer   wczt;
    private String  fbr;
    private String zpr;//指派人

    public String getZpr() {
        return zpr;
    }

    public void setZpr(String zpr) {
        this.zpr = zpr;
    }

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid;
    }

    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc;
    }

    public String getRwnr() {
        return rwnr;
    }

    public void setRwnr(String rwnr) {
        this.rwnr = rwnr;
    }

    public String getClr() {
        return clr;
    }

    public void setClr(String clr) {
        this.clr = clr;
    }

    public Integer getSfzp() {
        return sfzp;
    }

    public void setSfzp(Integer sfzp) {
        this.sfzp = sfzp;
    }

    public Integer getWczt() {
        return wczt;
    }

    public void setWczt(Integer wczt) {
        this.wczt = wczt;
    }

    public String getFbr() {
        return fbr;
    }

    public void setFbr(String fbr) {
        this.fbr = fbr;
    }

    private String chuliren;//业务字段
    private String faburen;//业务字段

    public Integer getShifouzhipai() {
        return shifouzhipai;
    }

    public void setShifouzhipai(Integer shifouzhipai) {
        this.shifouzhipai = shifouzhipai;
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

    public String getChulirenid() {
        return chulirenid;
    }

    public void setChulirenid(String chulirenid) {
        this.chulirenid = chulirenid;
    }

    public String getFaburenid() {
        return faburenid;
    }

    public void setFaburenid(String faburenid) {
        this.faburenid = faburenid;
    }

    @Override
    public String toString() {
        return "RenWu{" +
                "renwuid='" + renwuid + '\'' +
                ", renwuname='" + renwuname + '\'' +
                ", renwuneirong='" + renwuneirong + '\'' +
                ", wanchengstatus=" + wanchengstatus +
                ", chulirenid='" + chulirenid + '\'' +
                ", faburenid='" + faburenid + '\'' +
                ", shifouzhipai=" + shifouzhipai +
                ", rwid='" + rwid + '\'' +
                ", rwmc='" + rwmc + '\'' +
                ", rwnr='" + rwnr + '\'' +
                ", clr='" + clr + '\'' +
                ", sfzp=" + sfzp +
                ", wczt=" + wczt +
                ", fbr='" + fbr + '\'' +
                ", zpr='" + zpr + '\'' +
                ", chuliren='" + chuliren + '\'' +
                ", faburen='" + faburen + '\'' +
                '}';
    }
}
