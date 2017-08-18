package com.beini.test.javase.annotation;

import java.lang.reflect.Field;

/**
 * Created by beini on 2017/8/17.
 * 变量
 * 方法
 */
public class Test {
    @Testface(11)
    static int i;
    @Testface(22)
    static int age;

    public static void main(String[] aggs) throws IllegalAccessException {
        initFace(new Test());
        System.out.println("   i=" + i);
        System.out.println("  age=" + age);
    }

    private static void initFace(Test test) throws IllegalAccessException {
        Field[] fields = test.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotations() != null) {
                if (field.isAnnotationPresent(Testface.class)) {
                    field.setAccessible(true);
                    Testface testface = field.getAnnotation(Testface.class);
                    field.set(test, testface.value());
                }
            }
        }
    }


}
