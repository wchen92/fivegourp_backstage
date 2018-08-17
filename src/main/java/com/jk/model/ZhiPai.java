package com.jk.model;

public class ZhiPai {
    private String zhipaiid;//指派id
    private String renwuid;//任务id
    private String chilirenid;//指派人id
    private String renwuneirongid;//任务内容id
    private String faburenid;//发布人id

    private String renwuname;//任务名称
    private String username;//指派人
    private String renwuneirong;//任务内容
    private String faburenname;//发布人名称

    public String getFaburenname() {
        return faburenname;
    }

    public void setFaburenname(String faburenname) {
        this.faburenname = faburenname;
    }

    public String getFaburenid() {
        return faburenid;
    }

    public void setFaburenid(String faburenid) {
        this.faburenid = faburenid;
    }

    public String getRenwuname() {
        return renwuname;
    }

    public void setRenwuname(String renwuname) {
        this.renwuname = renwuname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRenwuneirongid() {
        return renwuneirongid;
    }

    public void setRenwuneirongid(String renwuneirongid) {
        this.renwuneirongid = renwuneirongid;
    }

    public String getRenwuneirong() {
        return renwuneirong;
    }

    public void setRenwuneirong(String renwuneirong) {
        this.renwuneirong = renwuneirong;
    }

    public String getZhipaiid() {
        return zhipaiid;
    }

    public void setZhipaiid(String zhipaiid) {
        this.zhipaiid = zhipaiid;
    }

    public String getRenwuid() {
        return renwuid;
    }

    public void setRenwuid(String renwuid) {
        this.renwuid = renwuid;
    }

    public String getChilirenid() {
        return chilirenid;
    }

    public void setChilirenid(String chilirenid) {
        this.chilirenid = chilirenid;
    }

    @Override
    public String toString() {
        return "ZhiPai{" +
                "zhipaiid='" + zhipaiid + '\'' +
                ", renwuid='" + renwuid + '\'' +
                ", chilirenid='" + chilirenid + '\'' +
                ", faburenid='" + faburenid + '\'' +
                '}';
    }
}
