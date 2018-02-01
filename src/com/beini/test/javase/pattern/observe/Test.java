package com.beini.test.javase.pattern.observe;


/**
 * Created by beini on 2018/2/1.
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new Demo1(subject);
        new Demo2(subject);
        new Demo3(subject);
        subject.setSate(33);
        subject.setSate(55);
    }
}
