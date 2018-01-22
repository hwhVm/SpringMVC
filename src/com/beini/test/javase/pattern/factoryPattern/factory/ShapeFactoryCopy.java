package com.beini.test.javase.pattern.factoryPattern.factory;

import com.beini.test.javase.pattern.factoryPattern.inter.Shape;
import com.beini.test.javase.pattern.factoryPattern.interimpl.Rectangle;
import com.beini.test.javase.pattern.factoryPattern.interimpl.Square;

/**
 * Created by beini on 2017/12/15.
 */
public class ShapeFactoryCopy {

    public Shape getShap(String type) {
        switch (type) {
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            default:
                throw new NullPointerException(" 没有匹配的类型 ");
        }
    }
}
