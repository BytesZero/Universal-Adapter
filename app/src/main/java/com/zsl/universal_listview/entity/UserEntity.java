package com.zsl.universal_listview.entity;

/**
 * Created by zsl on 15/5/19.
 */
public class UserEntity {

    private String name,sex,icon;

    public UserEntity(String name, String sex) {
        this.name = name;
        this.sex = sex;
        this.icon="http://img0.bdstatic.com/img/image/shouye/tpmlmxqd07.jpg";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
