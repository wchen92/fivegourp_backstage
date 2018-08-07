package com.jk.model;

public class JiangShi {
        private String    jiangshiid    ;              //讲师id
        private String    jiangshiname    ;                //讲师名称
        private String    jiangshishenfen   ;                 //讲师身份
        private String    jiangshijieshao      ;          //讲师简介

    public String getJiangshiid() {
        return jiangshiid;
    }

    public void setJiangshiid(String jiangshiid) {
        this.jiangshiid = jiangshiid;
    }

    public String getJiangshiname() {
        return jiangshiname;
    }

    public void setJiangshiname(String jiangshiname) {
        this.jiangshiname = jiangshiname;
    }

    public String getJiangshishenfen() {
        return jiangshishenfen;
    }

    public void setJiangshishenfen(String jiangshishenfen) {
        this.jiangshishenfen = jiangshishenfen;
    }

    public String getJiangshijieshao() {
        return jiangshijieshao;
    }

    public void setJiangshijieshao(String jiangshijieshao) {
        this.jiangshijieshao = jiangshijieshao;
    }

    @Override
    public String toString() {
        return "JiangShi{" +
                "jiangshiid='" + jiangshiid + '\'' +
                ", jiangshiname='" + jiangshiname + '\'' +
                ", jiangshishenfen='" + jiangshishenfen + '\'' +
                ", jiangshijieshao='" + jiangshijieshao + '\'' +
                '}';
    }
}
