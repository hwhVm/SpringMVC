package com.beini.test.javase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by beini on 2017/7/6.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
//        System.out.println("    " + A.class.getName());
//        Class classA = Class.forName(A.class.getName());
//        Class classB = A.class;

//        A a1 = (A) classA.newInstance();
//        A a2 = (A) classB.newInstance();

//        a2.returnA();

        //------------
        A a = A.class.newInstance();
        Field field = A.class.getDeclaredField("a");
        System.out.println("  field.getInt(a)=" + field.getInt(a));

//        Field field [] = A.class.getDeclaredFields() ; // 取得全部属性
//        for (int i=0;i<field.length;i++) {
//            System.out.println("    " + field[i]);
//        }

        Method method = a.getClass().getDeclaredMethod("printSomething",null);
        method.setAccessible(true);
        method.invoke(a,null);

//        Method[] methods = A.class.getDeclaredMethods();
//        for (int i = 0; i < methods.length; i++) {
//            System.out.println("取得SuperMan类的方法：");
//            System.out.println("函数名：" + methods[i].getName());
//            System.out.println("函数返回类型：" + methods[i].getReturnType());
//            System.out.println("函数访问修饰符：" + Modifier.toString(methods[i].getModifiers()));
//            System.out.println("函数代码写法： " + methods[i]);
//        }


    }
}
