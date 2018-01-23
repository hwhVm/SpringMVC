package com.beini.test.javase.thread.threadpool;

import com.beini.test.javase.thread.MainThread;

import java.util.concurrent.*;

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

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, linkedBlockingQueue);

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
