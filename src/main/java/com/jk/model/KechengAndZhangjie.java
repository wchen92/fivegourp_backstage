package com.jk.model;

public class KechengAndZhangjie {
    private String keandzhangid  ;//             课程和章节id
    private String kechengid   ;//                  课程id
    private String zhangjieid   ;//                 章节id

    public String getKeandzhangid() {
        return keandzhangid;
    }

    public void setKeandzhangid(String keandzhangid) {
        this.keandzhangid = keandzhangid;
    }

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    public String getZhangjieid() {
        return zhangjieid;
    }

    public void setZhangjieid(String zhangjieid) {
        this.zhangjieid = zhangjieid;
    }

    @Override
    public String toString() {
        return "KechengAndZhangjie{" +
                "keandzhangid='" + keandzhangid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                ", zhangjieid='" + zhangjieid + '\'' +
                '}';
    }
}
