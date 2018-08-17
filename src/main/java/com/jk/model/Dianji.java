package com.jk.model;

public class Dianji {
    private  String dianjiid;//点击id
    private  String kechengid;//课程id
    private  Integer kechengdianjiliang;//课程点击量
    private  String kechengname;//课程name
    private Integer page;//分页
    private Integer rows;//分页

    @Override
    public String toString() {
        return "Dianji{" +
                "dianjiid='" + dianjiid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                ", kechengdianjiliang=" + kechengdianjiliang +
                ", kechengname='" + kechengname + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", xlist='" + xlist + '\'' +
                ", ylist='" + ylist + '\'' +
                '}';
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRows() {
        return rows;
    }

    public String getKechengname() {
        return kechengname;
    }

    public void setKechengname(String kechengname) {
        this.kechengname = kechengname;
    }

    private  String xlist;
    private  String ylist;

    public void setXlist(String xlist) {
        this.xlist = xlist;
    }

    public void setYlist(String ylist) {
        this.ylist = ylist;
    }

    public String getXlist() {
        return xlist;
    }

    public String getYlist() {
        return ylist;
    }

    public void setDianjiid(String dianjiid) {
        this.dianjiid = dianjiid;
    }

    public void setKechengid(String kechengid) {
        this.kechengid = kechengid;
    }

    public void setKechengdianjiliang(Integer kechengdianjiliang) {
        this.kechengdianjiliang = kechengdianjiliang;
    }

    public String getDianjiid() {
        return dianjiid;
    }

    public String getKechengid() {
        return kechengid;
    }

    public Integer getKechengdianjiliang() {
        return kechengdianjiliang;
    }
}
