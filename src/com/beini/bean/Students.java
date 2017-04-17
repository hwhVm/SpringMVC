package com.beini.bean;

import java.io.Serializable;

/**
 * Created by beini on 2017/4/17.
 */
public class Students implements Serializable {
    private Integer stu_id;
    private String name;
    private Integer age;
    private ClassBean classBean;


    public ClassBean getClassBean() {
        return classBean;
    }

    public void setClassBean(ClassBean classBean) {
        this.classBean = classBean;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
