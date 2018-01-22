package com.beini.test.javase.pattern.factoryPattern.abstractFactory;

import com.beini.test.javase.pattern.factoryPattern.inter.Color;
import com.beini.test.javase.pattern.factoryPattern.inter.Shape;

/**
 * Created by beini on 2017/12/15.
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String className) {
        try {
            Class<?> c = Class.forName(className);
            return (Color) c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
