package com.beini.test.javase.pattern.decorativepattern.case2;

/**
 * Created by beini on 2018/2/5.
 * 抽象基类
 */
public abstract class Human {
    private String name;
    private String nation;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    protected String showInfo() {
        String desc = String.format("%s是个%s人，%s是%s人",
                getName(), (getSex() == 0) ? "男" : "女", (getSex() == 0) ? "他" : "她", getNation());
        return desc;
    }
}
