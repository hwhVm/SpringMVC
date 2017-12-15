package com.beini.test.javase.pattern.factory;

import com.beini.test.javase.pattern.factory.inter.Color;
import com.beini.test.javase.pattern.factory.inter.Shape;

/**
 * Created by beini on 2017/12/15.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
