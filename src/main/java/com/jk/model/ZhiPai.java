package com.jk.model;

public class ZhiPai {
    private String zhipaiid;//指派id
    private String renwuid;//任务id
    private String zhipairenid;//指派人id

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

    public String getZhipairenid() {
        return zhipairenid;
    }

    public void setZhipairenid(String zhipairenid) {
        this.zhipairenid = zhipairenid;
    }

    @Override
    public String toString() {
        return "ZhiPai{" +
                "zhipaiid='" + zhipaiid + '\'' +
                ", renwuid='" + renwuid + '\'' +
                ", zhipairenid='" + zhipairenid + '\'' +
                '}';
    }
}
