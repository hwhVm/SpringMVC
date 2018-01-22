package com.beini.test.javase.pattern.factoryPattern.interimpl;

import com.beini.test.javase.pattern.factoryPattern.inter.Shape;

/**
 * Created by beini on 2017/12/15.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle  draw");
    }
}
