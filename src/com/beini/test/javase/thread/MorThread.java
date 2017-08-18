package com.beini.test.javase.thread;

/**
 * Created by beini on 2017/8/17.
 */
public class MorThread {

    private static Object lock = new Object();
    int sum = 0;
    private Runnable runnable = () -> {
        synchronized (MorThread.class) {
            for (int i = 0; i <= 10; i++) {
                sum = sum + i;
            }
            System.out.println("------>sum=" + sum);
        }
    };

    public void star() {
            Thread thread = new Thread(runnable);
            thread.start();
    }
}
