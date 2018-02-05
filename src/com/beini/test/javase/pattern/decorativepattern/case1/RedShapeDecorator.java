package com.beini.test.javase.pattern.decorativepattern.case1;

/**
 * Created by beini on 2018/2/5.
 */
public class RedShapeDecorator extends ShapeDecoration {


    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void onDraw() {
        super.onDraw();
        setRead();
    }

    public void setRead() {
        System.out.println("setRead");
    }
}
