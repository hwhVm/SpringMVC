package com.beini.test.javase.sys;

/**
 * Created by beini on 2017/11/20.
 */
public class SynchronizedTest {

    public static void main(String args[]) {

    }

    public static synchronized void synMethod() {
        synchronized (SynchronizedTest.class) {

        }
    }


}
