package com.beini.test.javase.thread;

/**
 * Created by beini on 2017/8/16.
 */
public class MainThread {


    public static void main(String[] agrs) {
//        MorThread morThread = new MorThread();
//        for (int i = 0; i < 10; i++) {
//            morThread.star();
//        }

        for (int i = 0; i < 10; i++) {
            MyThread myThread1 = new MyThread(i);
            myThread1.start();
        }

    }

}

class MyThread extends Thread {
   private  int val;

    public MyThread(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        synchronized (MainThread.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("  val==" + val);
            }
        }

    }
}