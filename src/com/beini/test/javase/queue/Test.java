package com.beini.test.javase.queue;

import com.beini.test.javase.thread.threadpool.ThreadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by beini on 2018/1/25.
 */
public class Test {
  
    private static ExecutorService executors;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new LinkedBlockingDeque(5);
        Consumer consumer = new Consumer(blockingQueue);
        Producer producer1 = new Producer(blockingQueue);
//        Producer producer2 = new Producer(blockingQueue);
//        Producer producer3 = new Producer(blockingQueue);
//        Producer producer4 = new Producer(blockingQueue);
//        Producer producer5 = new Producer(blockingQueue);

        executors = Executors.newCachedThreadPool();
        executors.execute(producer1);
//        executors.execute(producer2);
//        executors.execute(producer3);
//        executors.execute(producer4);
//        executors.execute(producer5);
        executors.execute(consumer);
        Thread.sleep(30000);
        executors.shutdown();
        System.out.println("shutdown");
    }

    static class Consumer implements Runnable {
        BlockingQueue blockingQueue;

        public Consumer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                boolean isTrue = true;
                while (isTrue) {
                    if (executors.isShutdown()) {
                        isTrue = false;
                    }
                    Object object = blockingQueue.poll(2, TimeUnit.SECONDS);
                    if (object != null) {
                        int temp = (int) object;
                        System.out.println(" 在消费数据 temp=" + temp);
                        Thread.sleep(3000);
                    } else {
                        System.out.println(" 等待");
                    }

                }
            } catch (
                    InterruptedException e)

            {
                e.printStackTrace();
            }

        }

    }

    static class Producer implements Runnable {
        BlockingQueue blockingQueue;

        public Producer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                boolean isTrue = true;
                while (isTrue) {
                    if (executors.isShutdown()) {
                        isTrue = false;
                    }
                    blockingQueue.add(returnInt());
                    System.out.println(" 在生产数据 blockingQueue.size()=" + blockingQueue.size());
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public static int returnInt() {
        Random random = new Random();
        return (int) (random.nextDouble() * 10);
    }


    class DelayElement implements Delayed {

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
