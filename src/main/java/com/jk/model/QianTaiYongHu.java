package com.jk.model;

public class QianTaiYongHu {
    private String  yonghuid      ;//用户id
    private String yonghunicheng;//用户昵称
    private String  yonghuname    ;//   用户名称
    private String yonghusex;//用户性别
    private Integer yonghunianling;//用户年龄
    private String yonghutouxiang;//用户头像
    private String yonghumima;//用户密码
    private String yonghushoujihao;//用户手机号
    private String yonghuyouxiang;//用户邮箱
    private Integer shifouhuiyuan;//是否会员

    public String getYonghuid() {
        return yonghuid;
    }

    public void setYonghuid(String yonghuid) {
        this.yonghuid = yonghuid;
    }

    public String getYonghunicheng() {
        return yonghunicheng;
    }

    public void setYonghunicheng(String yonghunicheng) {
        this.yonghunicheng = yonghunicheng;
    }

    public String getYonghuname() {
        return yonghuname;
    }

    public void setYonghuname(String yonghuname) {
        this.yonghuname = yonghuname;
    }

    public String getYonghusex() {
        return yonghusex;
    }

    public void setYonghusex(String yonghusex) {
        this.yonghusex = yonghusex;
    }

    public Integer getYonghunianling() {
        return yonghunianling;
    }

    public void setYonghunianling(Integer yonghunianling) {
        this.yonghunianling = yonghunianling;
    }

    public String getYonghutouxiang() {
        return yonghutouxiang;
    }

    public void setYonghutouxiang(String yonghutouxiang) {
        this.yonghutouxiang = yonghutouxiang;
    }

    public String getYonghumima() {
        return yonghumima;
    }

    public void setYonghumima(String yonghumima) {
        this.yonghumima = yonghumima;
    }

    public String getYonghushoujihao() {
        return yonghushoujihao;
    }

    public void setYonghushoujihao(String yonghushoujihao) {
        this.yonghushoujihao = yonghushoujihao;
    }

    public String getYonghuyouxiang() {
        return yonghuyouxiang;
    }

    public void setYonghuyouxiang(String yonghuyouxiang) {
        this.yonghuyouxiang = yonghuyouxiang;
    }

    public Integer getShifouhuiyuan() {
        return shifouhuiyuan;
    }

    public void setShifouhuiyuan(Integer shifouhuiyuan) {
        this.shifouhuiyuan = shifouhuiyuan;
    }

    @Override
    public String toString() {
        return "QianTaiYongHu{" +
                "yonghuid='" + yonghuid + '\'' +
                ", yonghunicheng='" + yonghunicheng + '\'' +
                ", yonghuname='" + yonghuname + '\'' +
                ", yonghusex='" + yonghusex + '\'' +
                ", yonghunianling='" + yonghunianling + '\'' +
                ", yonghutouxiang='" + yonghutouxiang + '\'' +
                ", yonghumima='" + yonghumima + '\'' +
                ", yonghushoujihao='" + yonghushoujihao + '\'' +
                ", yonghuyouxiang='" + yonghuyouxiang + '\'' +
                ", shifouhuiyuan='" + shifouhuiyuan + '\'' +
                '}';
    }
}
