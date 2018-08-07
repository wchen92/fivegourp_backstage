package com.jk.model;

public class KeCheng {
    private String kechengid ;//            课程id
    private String kechengname    ;//       课程名称
    private String kechengprice   ;//       课程价格
    private String keshishu       ;//       课程数
    private String kechengphoto   ;//       课程图片
    private String kechengjieshao ;//       课程介绍
    private String huiyuanstatus   ;//      会员状态
    private String shenhestatus    ;//      审核状态

    public String getKechengid() {
        return kechengid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    public String getKechengname() {
        return kechengname;
    }

    public void setKechengname(String kechengname) {
        this.kechengname = kechengname;
    }

    public String getKechengprice() {
        return kechengprice;
    }

    public void setKechengprice(String kechengprice) {
        this.kechengprice = kechengprice;
    }

    public String getKeshishu() {
        return keshishu;
    }

    public void setKeshishu(String keshishu) {
        this.keshishu = keshishu;
    }

    public String getKechengphoto() {
        return kechengphoto;
    }

    public void setKechengphoto(String kechengphoto) {
        this.kechengphoto = kechengphoto;
    }

    public String getKechengjieshao() {
        return kechengjieshao;
    }

    public void setKechengjieshao(String kechengjieshao) {
        this.kechengjieshao = kechengjieshao;
    }

    public String getHuiyuanstatus() {
        return huiyuanstatus;
    }

    public void setHuiyuanstatus(String huiyuanstatus) {
        this.huiyuanstatus = huiyuanstatus;
    }

    public String getShenhestatus() {
        return shenhestatus;
    }

    public void setShenhestatus(String shenhestatus) {
        this.shenhestatus = shenhestatus;
    }

    @Override
    public String toString() {
        return "KeCheng{" +
                "kechengid='" + kechengid + '\'' +
                ", kechengname='" + kechengname + '\'' +
                ", kechengprice='" + kechengprice + '\'' +
                ", keshishu='" + keshishu + '\'' +
                ", kechengphoto='" + kechengphoto + '\'' +
                ", kechengjieshao='" + kechengjieshao + '\'' +
                ", huiyuanstatus='" + huiyuanstatus + '\'' +
                ", shenhestatus='" + shenhestatus + '\'' +
                '}';
    }
}
