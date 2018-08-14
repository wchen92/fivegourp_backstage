package com.jk.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GuangGaoBiao {

    private String guanggaoid; //广告id
    private String guanggaophoto;//广告图片
    private  String  guanggaoname;  //广告名称
    private Integer money;//广告钱
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date guanggaodate;//广告时间
    private Integer  zhanshistatus;//展示状态
    private String  chuliren;//处理人


    public String getGuanggaoid() {
        return guanggaoid;
    }

    public void setGuanggaoid(String guanggaoid) {
        this.guanggaoid = guanggaoid;
    }

    public String getGuanggaophoto() {
        return guanggaophoto;
    }

    public void setGuanggaophoto(String guanggaophoto) {
        this.guanggaophoto = guanggaophoto;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getGuanggaodate() {
        return guanggaodate;
    }

    public Date setGuanggaodate(Date guanggaodate) {
        this.guanggaodate = guanggaodate;
        return guanggaodate;
    }

    public Integer getZhanshistatus() {
        return zhanshistatus;
    }

    public void setZhanshistatus(Integer zhanshistatus) {
        this.zhanshistatus = zhanshistatus;
    }

    public String getChuliren() {
        return chuliren;
    }

    public void setChuliren(String chuliren) {
        this.chuliren = chuliren;
    }

    public String getGuanggaoname() {
        return guanggaoname;
    }

    public void setGuanggaoname(String guanggaoname) {
        this.guanggaoname = guanggaoname;
    }

    @Override
    public String toString() {
        return "GuangGaoBiao{" +
                "guanggaoid='" + guanggaoid + '\'' +
                ", guanggaophoto='" + guanggaophoto + '\'' +
                ", guanggaoname='" + guanggaoname + '\'' +
                ", money=" + money +
                ", guanggaodate=" + guanggaodate +
                ", zhanshistatus=" + zhanshistatus +
                ", chuliren='" + chuliren + '\'' +
                '}';
    }
}
