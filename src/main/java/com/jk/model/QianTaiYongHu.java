package com.jk.model;

public class QianTaiYongHu {
           private String  yonghuid      ;//用户id

           private String  yonghuname    ;//   用户名称

    public String getYonghuid() {
        return yonghuid;
    }

    public void setYonghuid(String yonghuid) {
        this.yonghuid = yonghuid;
    }

    public String getYonghuname() {
        return yonghuname;
    }

    public void setYonghuname(String yonghuname) {
        this.yonghuname = yonghuname;
    }

    @Override
    public String toString() {
        return "QianTaiYongHu{" +
                "yonghuid='" + yonghuid + '\'' +
                ", yonghuname='" + yonghuname + '\'' +
                '}';
    }
}
