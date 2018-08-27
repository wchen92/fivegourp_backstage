package com.jk.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 谭永生
 * @Title: WenDa
 * @ProjectName fivegourp_backstage
 * @Description: TODO
 * @date 2018/8/17 20:28
 */
public class WenDa {

    private  Integer  id;
    private  String   text;
    private  Integer  pid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date     wdate;
    private List<WenDa> list;

    private String showdate;

    public String getShowdate() {
        return showdate;
    }

    public void setShowdate(String showdate) {
        this.showdate = showdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public List<WenDa> getList() {
        return list;
    }

    public void setList(List<WenDa> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WenDa{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                ", wdate=" + wdate +
                ", list=" + list +
                '}';
    }
}
