package com.beini.test.javase.thread.allocation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by beini on 2018/1/10.
 */
public class ThreadAllocation {
    private static ExecutorService fixThradPool = Executors.newFixedThreadPool(5);


    public static void main(String[] args) {
        fixThradPool.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end 1 " + Thread.currentThread().getName());
        });

        fixThradPool.execute(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end 2 " + Thread.currentThread().getName());
                }
        );

    }

    interface CountListenter {
        void onSuccess();
        void onFaile();
    }
}
