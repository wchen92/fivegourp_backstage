package com.jk.model;

import java.util.Date;

/**
 * @ 创建者：王晨.
 * @ 创建时间：2018/8/27 20:07
 * @ Description：
 * @ Version:
 */
public class peixun {

  private String   id                        ;
  private String           name              ;
  private Integer   sex                       ;
  private String           shouji            ;
  private String   weixinhao                 ;
  private Integer           xueli             ;
  private String biyeshijian               ;
  private String           xinzi             ;
  private Integer   zhuangtai                 ;
  private String           zhidingchuliid    ;
  private Integer   chulizhuangtai            ;
  private String jieguo;

    public String getJieguo() {
        return jieguo;
    }

    public void setJieguo(String jieguo) {
        this.jieguo = jieguo;
    }

    private String qqhao;

    public String getQqhao() {
        return qqhao;
    }

    public void setQqhao(String qqhao) {
        this.qqhao = qqhao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getShouji() {
        return shouji;
    }

    public void setShouji(String shouji) {
        this.shouji = shouji;
    }

    public String getWeixinhao() {
        return weixinhao;
    }

    public void setWeixinhao(String weixinhao) {
        this.weixinhao = weixinhao;
    }

    public Integer getXueli() {
        return xueli;
    }

    public void setXueli(Integer xueli) {
        this.xueli = xueli;
    }

    public String getBiyeshijian() {
        return biyeshijian;
    }

    public void setBiyeshijian(String biyeshijian) {
        this.biyeshijian = biyeshijian;
    }

    public String getXinzi() {
        return xinzi;
    }

    public void setXinzi(String xinzi) {
        this.xinzi = xinzi;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getZhidingchuliid() {
        return zhidingchuliid;
    }

    public void setZhidingchuliid(String zhidingchuliid) {
        this.zhidingchuliid = zhidingchuliid;
    }

    public Integer getChulizhuangtai() {
        return chulizhuangtai;
    }

    public void setChulizhuangtai(Integer chulizhuangtai) {
        this.chulizhuangtai = chulizhuangtai;
    }


    @Override
    public String toString() {
        return "peixun{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", shouji='" + shouji + '\'' +
                ", weixinhao='" + weixinhao + '\'' +
                ", xueli=" + xueli +
                ", biyeshijian=" + biyeshijian +
                ", xinzi='" + xinzi + '\'' +
                ", zhuangtai=" + zhuangtai +
                ", zhidingchuliid='" + zhidingchuliid + '\'' +
                ", chulizhuangtai=" + chulizhuangtai +
                ", qqhao='" + qqhao + '\'' +
                '}';
    }
}
