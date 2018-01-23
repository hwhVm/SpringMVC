package com.beini.test.javase.pattern.factoryPattern.staticFactory;

import com.beini.test.javase.pattern.factoryPattern.interimpl.Rectangle;
import com.beini.test.javase.pattern.factoryPattern.interimpl.Square;

/**
 * Created by beini on 2018/1/23.
 */
public class ShapeStaticFactory {

    public static Rectangle getRectangle() {
        return new Rectangle();
    }

    public static Square getSquare() {
        return new Square();
    }
}
