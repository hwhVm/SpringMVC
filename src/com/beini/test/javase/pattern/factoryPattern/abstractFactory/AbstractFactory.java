package com.beini.test.javase.pattern.factoryPattern.abstractFactory;

import com.beini.test.javase.pattern.factoryPattern.inter.Color;
import com.beini.test.javase.pattern.factoryPattern.inter.Shape;

/**
 * Created by beini on 2017/12/15.
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
