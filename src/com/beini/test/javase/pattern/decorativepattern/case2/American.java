package com.beini.test.javase.pattern.decorativepattern.case2;

/**
 * Created by beini on 2018/2/5.
 * 装饰好的派生类
 */
public class American extends People {
    public American(Human base) {
        super(base);
        setNation("美国");
    }
}
