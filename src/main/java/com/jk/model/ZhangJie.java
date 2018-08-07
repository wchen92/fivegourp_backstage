package com.jk.model;

public class ZhangJie {
          private String  zhangjieid             ;//章节id

          private String  banxingid              ;//    班型id

          private String  shipin                 ;//   视频

          private String  shoufeistatus          ;//    收费状态

    public String getZhangjieid() {
        return zhangjieid;
    }

    public void setZhangjieid(String zhangjieid) {
        this.zhangjieid = zhangjieid;
    }

    public String getBanxingid() {
        return banxingid;
    }

    public void setBanxingid(String banxingid) {
        this.banxingid = banxingid;
    }

    public String getShipin() {
        return shipin;
    }

    public void setShipin(String shipin) {
        this.shipin = shipin;
    }

    public String getShoufeistatus() {
        return shoufeistatus;
    }

    @Override
    public String toString() {
        return "ZhangJie{" +
                "zhangjieid='" + zhangjieid + '\'' +
                ", banxingid='" + banxingid + '\'' +
                ", shipin='" + shipin + '\'' +
                ", shoufeistatus='" + shoufeistatus + '\'' +
                '}';
    }

    public void setShoufeistatus(String shoufeistatus) {
        this.shoufeistatus = shoufeistatus;
    }
}
