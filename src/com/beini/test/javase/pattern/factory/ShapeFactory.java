package com.beini.test.javase.pattern.factory;

import com.beini.test.javase.pattern.factory.inter.Color;
import com.beini.test.javase.pattern.factory.inter.Shape;

/**
 * Created by beini on 2017/12/15.
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String className) {
        try {
            Class<?> c = Class.forName(className);
            return (Shape) c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
