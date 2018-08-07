package com.jk.model;

import java.util.Date;

public class GuangGaoBiao {

    private String guanggaoid; //广告id
    private String guanggaophoto;//广告图片
    private Integer money;//广告钱
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

    public void setGuanggaodate(Date guanggaodate) {
        this.guanggaodate = guanggaodate;
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

    @Override
    public String toString() {
        return "GuangGaoBiao{" +
                "guanggaoid='" + guanggaoid + '\'' +
                ", guanggaophoto='" + guanggaophoto + '\'' +
                ", money='" + money + '\'' +
                ", guanggaodate='" + guanggaodate + '\'' +
                ", zhanshistatus='" + zhanshistatus + '\'' +
                ", chuliren='" + chuliren + '\'' +
                '}';
    }
}
