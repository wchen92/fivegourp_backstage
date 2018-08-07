package com.jk.model;

public class roleAndpower {
         private String     roleid     ;//    角色id
         private String     Id         ;//    权限id

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "roleAndpower{" +
                "roleid='" + roleid + '\'' +
                ", Id='" + Id + '\'' +
                '}';
    }
}
