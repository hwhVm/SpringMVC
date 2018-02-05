package com.beini.test.javase.pattern.decorativepattern.case2;

/**
 * Created by beini on 2018/2/5.
 */
public class Test {
    public static void main(String[] arg) {
        Human one = new Chinese(new Man(new Person("张三")));
        Human two = new Chinese(new Woman(new Person("邓丽君")));
        Human three = new American(new Man(new Person("乔布斯")));
        Human four = new American(new Woman(new Person("露茜")));

        Human gdPeople = new GdPeople(new Chinese(new Man(new Person("beini"))));

        System.out.println(one.showInfo());
        System.out.println(two.showInfo());
        System.out.println(three.showInfo());
        System.out.println(four.showInfo());
    }
}
