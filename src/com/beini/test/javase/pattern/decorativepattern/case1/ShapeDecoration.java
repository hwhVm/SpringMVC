package com.beini.test.javase.pattern.decorativepattern.case1;

/**
 * Created by beini on 2018/2/5.
 */
public abstract class ShapeDecoration implements Shape {
    private Shape shape;

    public ShapeDecoration(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void onDraw() {
        shape.onDraw();
    }
}
