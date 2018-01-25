package com.beini.test.javase.thread.threadpool;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by beini on 2018/1/24.
 */
public class Test {
    private Thread tread = new Thread() {
        @Override
        public void run() {
            super.run();
        }
    };
    private static ExecutorService executor;

    static {
        executor = Executors.newSingleThreadExecutor();
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
//        Test test = new Test();
//        test.tread.start();
    }

    public void test() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);        //创建含10.条线程的线程池
        CompletionService completionService = new ExecutorCompletionService(executor);
        for (int i = 1; i <= 10; i++) {
            final int result = i;
            completionService.submit(new Callable() {
                public Object call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));   //让当前线程随机休眠一段时间
                    return result;
                }
            });
        }
        System.out.println(completionService.take().get());   //获取执行结果

    }

    public static void callableSubmit() {
        //阻塞线程
        Future<?> funcTrue2 = executor.submit(() -> {
            Thread.sleep(3000);
            return "hi beini";
        });
        try {
            System.out.println("   " + funcTrue2.get());
            System.out.println(" end ");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void printRunState() {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = -1 << COUNT_BITS;
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP = 1 << COUNT_BITS;
        int TIDYING = 2 << COUNT_BITS;
        int TERMINATED = 3 << COUNT_BITS;
        System.out.println("RUNNING=" + RUNNING);//-536870912
        System.out.println("SHUTDOWN=" + SHUTDOWN);//0
        System.out.println("STOP=" + STOP);//536870912
        System.out.println("TIDYING=" + TIDYING);//1073741824
        System.out.println("TERMINATED=" + TERMINATED);//1610612736
    }

    public static void testCrlOf() {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = -1 << COUNT_BITS;
        System.out.println("RUNNING=" + RUNNING);
        AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        System.out.println("ctl=" + ctl);
    }

    private static int ctlOf(int rs, int wc) {
        int reuslt = rs | wc;
        System.out.println("reuslt=" + reuslt);
        return reuslt;
    }
}
