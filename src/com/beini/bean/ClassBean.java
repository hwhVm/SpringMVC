package com.beini.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by beini on 2017/4/17.
 */
public class ClassBean implements Serializable {

    private Integer class_id;
    private String grade;
    private Integer count;
    private List<Students> stdudents;

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Students> getStdudents() {
        return stdudents;
    }

    public void setStdudents(List<Students> stdudents) {
        this.stdudents = stdudents;
    }

}
