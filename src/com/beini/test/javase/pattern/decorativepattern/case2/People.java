package com.beini.test.javase.pattern.decorativepattern.case2;

/**
 * Created by beini on 2018/2/5.
 * 待装饰的基类
 */
public abstract class People extends Human {
    private Human mBase;

    public People(Human base) {
        mBase = base;
    }

    public void setName(String name) {
        mBase.setName(name);
    }

    public String getName() {
        return mBase.getName();
    }

    public void setNation(String nation) {
        mBase.setNation(nation);
    }

    public String getNation() {
        return mBase.getNation();
    }

    public void setSex(int sex) {
        mBase.setSex(sex);
    }

    public int getSex() {
        return mBase.getSex();
    }
}