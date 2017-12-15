package com.beini.test.javase.pattern.factory;


/**
 * Created by beini on 2017/12/15.
 */
public class FactoryProduce {

    public Object getFactory(String className) {
        try {
            Class<?> c = Class.forName(className);
            return c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }

    }
}
