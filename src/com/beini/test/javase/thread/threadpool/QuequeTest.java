package com.beini.test.javase.thread.threadpool;

import java.util.concurrent.*;

/**
 * Created by beini on 2018/1/23.
 */
public class QuequeTest implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        /**
         * 1 避免占用过多的内存和消耗資源
         * 2 合理的管理线程池
         */
        // 1 初始化
        /**
         * The queue used for holding tasks and handing off to worker
         * threads.  We do not require that workQueue.poll() returning
         * null necessarily means that workQueue.isEmpty(), so rely
         * solely on isEmpty to see if the queue is empty (which we must
         * do for example when deciding whether to transition from
         * SHUTDOWN to TIDYING).  This accommodates special-purpose
         * queues such as DelayQueues for which poll() is allowed to
         * return null even if it may later return non-null when delays
         * expire.
         */
        /**
         * 阻塞队列
         *这个队列用于持和操作工作线程。
         */
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        /**
         * 普通构造函数创建实例
         * @param corePoolSize 不管线程池是否空闲,工作的线程数.除非设置了{@code allowCoreThreadTimeOut}
         * @param maximumPoolSize 允许的最大线程数
         * @param keepAliveTime 空闲线程的存活时间,当一个线程执行完，且当前线程池数大于corePoolSize，线程池会停止空闲的线程，保持当前工作线程为corePoolSize
         * @param unit {@code keepAliveTime}的基本单位
         * @param workQueue 保存执行前的任务线程
         * 可能抛出的异常：以上的参数出现类型不匹配就,corePoolSize>maximumPoolSize等：IllegalArgumentException，workQueue为null等:NullPointerException
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
        // 2 参数赋值
        /**
         *@param threadFactory 默认的线程工厂
         *@param handler 超过线程池和队列的最大值的时候通过handler触发RejectedExecutionException异常
         * this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
         * Executors.defaultThreadFactory(), defaultHandler);
         */
        // 3 执行
        /**
         * 传进去的线程會在未來的某個時候被执行,这个任务可能在一个新的线程或者在一个存在的线程池里被执行。（ may execute in a new thread or in an existing pooled thread.）
         * 如果executor被关闭或者超过他的容量，抛出 RejectedExecution
         */
        Thread thread = new Thread(new QuequeTest());
        executor.execute(thread);
        // 4 execute 方法
        /**
         *  1 如果工作线程小于corePoolSize，启动一个新线程，这个方法自动调用addWorker检查运行状态和workerCount;如果工作线程数大于等于corePoolSiz,会将这个任务添加到队列
         *  2 如果任务成功添加到队列，还需要仔细检查是否已经添加到了线程,不能添加是返回false；
         *  3 如果不能添加执行队列的任务，会尝试添加新的线程，如果添加失败，线程池可能被关闭或者饱和，因此会拒绝这个任务。
         */

        /**
         * ctl:AtomicInteger是在使用非阻塞算法实现并发控制，在一些高并发程序中非常适合，但并不能每一种场景都适合，不同场景要使用使用不同的数值类。
         */
//        int c = ctl.get();

//        if (workerCountOf(c) < corePoolSize) {
        /**
         * 在addWorker里进行了相关的判定，然后start
         */
//            if (addWorker(command, true))
//                return;
//            c = ctl.get();
//        }
//        if (isRunning(c) && workQueue.offer(command)) {
//            int recheck = ctl.get();
//            if (! isRunning(recheck) && remove(command))
//                reject(command);
//            else if (workerCountOf(recheck) == 0)
//                addWorker(null, false);
//        }
//        else if (!addWorker(command, false))
//            reject(command);
        //当一个任务执行完后，会从队列取出下一个任务来执行
        //


        /**
         * 用线程池工厂(@{@link Executors})创建实例，
         */
//        ExecutorService fixThradPool = Executors.newFixedThreadPool(5);
//        ExecutorService newCacheThreadPool = Executors.newCachedThreadPool();
//        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
//        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

//        for (
//                int i = 0;
//                i < 10; i++)
//
//        {
//            executor.execute(new Thread(new QuequeTest(), "TestThread".concat("" + i)));
//            int threadSize = queue.size();
//            System.out.println("线程队列大小为-->" + threadSize);
//        }
//        executor.shutdown();
    }
}
