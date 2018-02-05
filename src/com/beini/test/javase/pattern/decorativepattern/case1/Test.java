package com.beini.test.javase.pattern.decorativepattern.case1;


/**
 * Created by beini on 2018/2/5.
 */
public class Test {
    public static void main(String[] arg) {
        Shape shape = new RedShapeDecorator(new Rectangle());
        shape.onDraw();
        Shape shape1 = new Rectangle();
        shape1.onDraw();
    }
}
