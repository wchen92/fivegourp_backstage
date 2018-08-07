package com.jk.model;

public class userAndrole {
       private String       userid   ;//用户id

       private String      roleid    ;//    角色id

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "userAndrole{" +
                "userid='" + userid + '\'' +
                ", roleid='" + roleid + '\'' +
                '}';
    }
}
