package com.beini.test.javase.classcast;


/**
 * Created by beini on 2017/10/27.
 */
public class TestClassForName {

    public static void main(String[] args) {

//        ChildSupTest demo1 = (ChildSupTest) createInstance(ChildSupTest.class);
//        ChildSupTest demo2 = (ChildSupTest) createInstance(ChildSupTest.class);
//        System.out.println("  demo2==demo1" + (demo1 == demo2));

        String str;

    }


    public static Object createInstance(Class<?> className) {
        try {
            Class<?> c = Class.forName(className.getName());
            try {
                return c.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
