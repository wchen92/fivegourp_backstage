package com.jk.model;

public class Power {
         private String    id      ;//权限id

         private String    text    ;//    名称

         private String     pid    ;//    pid

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Power{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}
