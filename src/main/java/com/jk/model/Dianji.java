package com.jk.model;

public class Dianji {
    private  String dianjiid;
    private  String kechengid;
    private  Integer kechengdianjiliang;
    private  String kechengname;

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

    @Override
    public String toString() {
        return "Dianji{" +
                "dianjiid='" + dianjiid + '\'' +
                ", kechengid='" + kechengid + '\'' +
                ", kechengdianjiliang=" + kechengdianjiliang +
                '}';
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
