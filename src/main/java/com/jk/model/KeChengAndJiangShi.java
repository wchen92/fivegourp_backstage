package com.jk.model;

public class KeChengAndJiangShi {
    private String kechengandjiangshiid ;//   课程和讲师id
    private String         kechengid  ;//     课程id
    private String jiangshiid      ;//        讲师id

    public String getKechengandjiangshiid() {
        return kechengandjiangshiid;
    }

    public void setKechengandjiangshiid(String kechengandjiangshiid) {
        this.kechengandjiangshiid = kechengandjiangshiid;
    }

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    public String getJiangshiid() {
        return jiangshiid;
    }

    public void setJiangshiid(String jiangshiid) {
        this.jiangshiid = jiangshiid;
    }

    @Override
    public String toString() {
        return "KeChengAndJiangShi{" +
                "kechengandjiangshiid='" + kechengandjiangshiid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                ", jiangshiid='" + jiangshiid + '\'' +
                '}';
    }
}
