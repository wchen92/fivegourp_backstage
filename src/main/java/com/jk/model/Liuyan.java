package com.jk.model;

public class Liuyan {
    private String liulanid;//           浏览id
    private String kechengid;//           课程id
    private Integer liulanshuliang;//      浏览数量

    public String getLiulanid() {
        return liulanid;
    }

    public void setLiulanid(String liulanid) {
        this.liulanid = liulanid;
    }

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    public Integer getLiulanshuliang() {
        return liulanshuliang;
    }

    public void setLiulanshuliang(Integer liulanshuliang) {
        this.liulanshuliang = liulanshuliang;
    }

    @Override
    public String toString() {
        return "Liuyan{" +
                "liulanid='" + liulanid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                ", liulanshuliang='" + liulanshuliang + '\'' +
                '}';
    }
}
