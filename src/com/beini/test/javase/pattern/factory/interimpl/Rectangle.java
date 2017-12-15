package com.beini.test.javase.pattern.factory.interimpl;

import com.beini.test.javase.pattern.factory.inter.Shape;

/**
 * Created by beini on 2017/12/15.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle  draw");
    }
}
