package com.jk.model;

import java.util.Date;

public class HuiyuanAndYonghu {
   private String  huiyuanyonghuid; //主键id
   private String  yonghuid;    //用户id
   private Date chongzhidate;//充值时间

    public String getHuiyuanyonghuid() {
        return huiyuanyonghuid;
    }

    public void setHuiyuanyonghuid(String huiyuanyonghuid) {
        this.huiyuanyonghuid = huiyuanyonghuid;
    }

    public String getYonghuid() {
        return yonghuid;
    }

    public void setYonghuid(String yonghuid) {
        this.yonghuid = yonghuid;
    }

    public Date getChongzhidate() {
        return chongzhidate;
    }

    public void setChongzhidate(Date chongzhidate) {
        this.chongzhidate = chongzhidate;
    }

    @Override
    public String toString() {
        return "HuiyuanAndYonghu{" +
                "huiyuanyonghuid='" + huiyuanyonghuid + '\'' +
                ", yonghuid='" + yonghuid + '\'' +
                ", chongzhidate=" + chongzhidate +
                '}';
    }
}
