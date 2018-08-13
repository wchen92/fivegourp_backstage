package com.jk.model;

public class ZhangJie {
          private String  zhangjieid             ;//章节id

          private String  zhangjiename              ;//    章节名称

          private String  shipin                 ;//   视频

          private String  shoufeistatus          ;//    收费状态

    public String getZhangjieid() {
        return zhangjieid;
    }

    public void setZhangjieid(String zhangjieid) {
        this.zhangjieid = zhangjieid;
    }

    public String getZhangjiename() {
        return zhangjiename;
    }

    public void setZhangjiename(String zhangjiename) {
        this.zhangjiename = zhangjiename;
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

    public void setShoufeistatus(String shoufeistatus) {
        this.shoufeistatus = shoufeistatus;
    }

    @Override
    public String toString() {
        return "ZhangJie{" +
                "zhangjieid='" + zhangjieid + '\'' +
                ", zhangjiename='" + zhangjiename + '\'' +
                ", shipin='" + shipin + '\'' +
                ", shoufeistatus='" + shoufeistatus + '\'' +
                '}';
    }
}
