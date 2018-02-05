package com.beini.test.javase.pattern.decorativepattern.case2;

/**
 * Created by beini on 2018/2/5.
 * 装饰好的派生类
 */
public class Man extends People {
    public Man(Human base) {
        super(base);
        setSex(0);
    }

}
