package com.jk.model;

public class Role {
      private String        roleid  ;//角色id

      private String       text     ;//    名称

      private String       pid      ;//    pid

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
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

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + roleid + '\'' +
                ", text='" + text + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}
