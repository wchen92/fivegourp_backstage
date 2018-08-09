package com.jk.model;

public class User {
          private String   userid              ;//系统人员id

          private String   text                ;//    名称

          private String   pid                 ;//    pid

          private String   password            ;//    密码

         private  Integer userstatus;  //状态   1.已审核 2.未审核

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", text='" + text + '\'' +
                ", pid='" + pid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
