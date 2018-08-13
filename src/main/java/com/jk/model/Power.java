package com.jk.model;

public class Power {
         private String    id      ;//权限id

         private String    text    ;//    名称

         private String     pid    ;//    pid

        private String url;//进方法路径

    private   Boolean   checked;  //

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Power{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", pid='" + pid + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
