package com.beini.bean;

import java.io.Serializable;

/**
 * Created by beini on 2017/4/15.
 */
public class Leader implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Leader(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Leader(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
