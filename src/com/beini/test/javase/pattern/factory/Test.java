package com.beini.test.javase.pattern.factory;

import com.beini.test.javase.pattern.factory.interimpl.Rectangle;
import com.beini.test.javase.pattern.factory.interimpl.Red;
import com.beini.test.javase.pattern.factory.interimpl.Square;

/**
 * Created by beini on 2017/12/15.
 */
public class Test {

    public static void main(String args[]) {
//        ShapeFactory shapeFactory = new ShapeFactory();
//        Rectangle rectangle = (Rectangle) shapeFactory.getShap("Rectangle");
//        rectangle.draw();
//        Square square = (Square) shapeFactory.getShap("Square");
//        square.draw();

        FactoryProduce factoryProduce = new FactoryProduce();
        Rectangle rectangle = (Rectangle) factoryProduce.getFactory(Rectangle.class.getName());
        rectangle.draw();

        Red red = (Red) factoryProduce.getFactory(Red.class.getName());
        red.fill();


        Rectangle rectangle1 = new Rectangle();
        rectangle1.draw();
    }

}
