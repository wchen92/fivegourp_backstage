package com.jk.model;

/**
 * @ 创建者：赵清顺.
 * @ 创建时间：2018/8/15 0015 9:10
 * @ Description：
 * @ Version:
 */
public class MinGanCi {

    private String minganid;

    private String minganname;

    public String getMinganid() {
        return minganid;
    }

    public void setMinganid(String minganid) {
        this.minganid = minganid;
    }

    public String getMinganname() {
        return minganname;
    }

    public void setMinganname(String minganname) {
        this.minganname = minganname;
    }

    @Override
    public String toString() {
        return "MinGanCi{" +
                "minganid='" + minganid + '\'' +
                ", minganname='" + minganname + '\'' +
                '}';
    }
}
