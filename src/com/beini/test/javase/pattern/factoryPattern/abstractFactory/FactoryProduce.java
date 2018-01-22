package com.beini.test.javase.pattern.factoryPattern.abstractFactory;

/**
 * Created by beini on 2018/1/22.
 */
public class FactoryProduce {

    public static AbstractFactory getFactory(String type) {
        switch (type) {
            case "Color":
                return new ColorFactory();
            case "Shape":
                return new ShapeFactory();
        }
        return null;
    }

}
