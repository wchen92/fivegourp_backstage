package com.jk.model;

import java.util.List;

public class KeCheng {
    private String kechengid ;//            课程id
    private String kechengname    ;//       课程名称
    private String kechengprice   ;//       课程价格
    private String keshishu       ;//       课程数
    private String kechengphoto   ;//       课程图片
    private String kechengjieshao ;//       课程介绍
    private String huiyuanstatus   ;//      会员状态
    private String shenhestatus    ;//      审核状态
    private Integer page;
    private Integer rows;

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRows() {
        return rows;
    }



    //业务字段
    private String huiyuan;  //会员

    private  String liulanliang; // 浏览量

    private long ksshu;//课时数

    private List<ZhangJie> zjlist;//存入章节信息集合

    private String jiangshi;
    private String jssf;

    private String banxing;

    public String getBanxing() {
        return banxing;
    }

    public void setBanxing(String banxing) {
        this.banxing = banxing;
    }

    public String getJiangshi() {
        return jiangshi;
    }

    public void setJiangshi(String jiangshi) {
        this.jiangshi = jiangshi;
    }

    public String getJssf() {
        return jssf;
    }

    public void setJssf(String jssf) {
        this.jssf = jssf;
    }

    public long getKsshu() {
        return ksshu;
    }

    public void setKsshu(long ksshu) {
        this.ksshu = ksshu;
    }

    public String getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(String huiyuan) {
        this.huiyuan = huiyuan;
    }

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

    public String getLiulanliang() {
        return liulanliang;
    }

    public void setLiulanliang(String liulanliang) {
        this.liulanliang = liulanliang;
    }

    public List<ZhangJie> getZjlist() {
        return zjlist;
    }

    public void setZjlist(List<ZhangJie> zjlist) {
        this.zjlist = zjlist;
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
                ", page=" + page +
                ", rows=" + rows +
                ", huiyuan='" + huiyuan + '\'' +
                ", liulanliang='" + liulanliang + '\'' +
                ", ksshu=" + ksshu +
                ", zjlist=" + zjlist +
                ", jiangshi='" + jiangshi + '\'' +
                ", jssf='" + jssf + '\'' +
                ", banxing='" + banxing + '\'' +
                '}';
    }
}
