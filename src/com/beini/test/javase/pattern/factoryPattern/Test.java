package com.beini.test.javase.pattern.factoryPattern;

import com.beini.test.javase.pattern.factoryPattern.abstractFactory.AbstractFactory;
import com.beini.test.javase.pattern.factoryPattern.abstractFactory.FactoryProduce;
import com.beini.test.javase.pattern.factoryPattern.abstractFactory.ShapeFactory;
import com.beini.test.javase.pattern.factoryPattern.inter.Shape;
import com.beini.test.javase.pattern.factoryPattern.interimpl.Rectangle;
import com.beini.test.javase.pattern.factoryPattern.interimpl.Square;
import com.beini.test.javase.pattern.factoryPattern.staticFactory.ShapeStaticFactory;

/**
 * Created by beini on 2017/12/15.
 */
public class Test {

    public static void main(String args[]) {

//        ShapeFactoryCopy shapeFactoryCopy = new ShapeFactoryCopy();
//        Shape shapeRectangle = shapeFactoryCopy.getShap("Rectangle");
//        shapeRectangle.draw();
//
//        Shape shapeSquare = shapeFactoryCopy.getShap("Square");
//        shapeSquare.draw();
        //
//        ShapeFactory shapeFactory = new ShapeFactory();
//        Shape rectangle = shapeFactory.getShape(Rectangle.class.getName());
//        rectangle.draw();
//        Shape square = shapeFactory.getShape(Square.class.getName());
//        square.draw();
        //抽象工厂
//        AbstractFactory shapeFactory = FactoryProduce.getFactory("Shape");
//        Shape shape = shapeFactory.getShape(Square.class.getName());
//        shape.draw();
        //静态工厂
        Shape rectangle = ShapeStaticFactory.getRectangle();
        rectangle.draw();
        Shape square = ShapeStaticFactory.getSquare();
        square.draw();

    }

}
