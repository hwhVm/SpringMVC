package com.beini.test.javase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by beini on 2017/8/16.
 */
public class ThreadPool {

    private static ExecutorService fixThradPool = Executors.newFixedThreadPool(5);
    private static ExecutorService newCacheThreadPool = Executors.newCachedThreadPool();
    private static ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
    private static ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        MainThread mainThread = new MainThread();

//        fixThradPool.execute(() -> {
//            try {
//                for (int i = 0; i < 20; i++) {
//                    Thread.sleep(1000);
//                    System.out.println("  -----> " + i);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread.sleep(4000);
//        fixThradPool.shutdown();
//        System.out.println("   --------->  " + fixThradPool.isShutdown());
    }
}
