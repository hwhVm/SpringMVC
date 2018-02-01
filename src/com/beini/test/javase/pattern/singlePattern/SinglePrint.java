package com.beini.test.javase.pattern.singlePattern;

/**
 * Created by beini on 2018/1/26.
 */
public class SinglePrint {
    private static SinglePrint singlePrint = new SinglePrint();

    //
    public static SinglePrint getInstance() {
        return singlePrint;
    }

}
