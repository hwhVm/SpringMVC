package com.beini.test.javase.pattern.factory;

import com.beini.test.javase.pattern.factory.inter.Color;
import com.beini.test.javase.pattern.factory.inter.Shape;

/**
 * Created by beini on 2017/12/15.
 */
public class ColorFactory extends AbstractFactory {

    @Override
    Color getColor(String className) {
        try {
            Class<?> c = Class.forName(className);
            return (Color) c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
