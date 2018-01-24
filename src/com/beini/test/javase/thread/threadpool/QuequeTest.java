package com.beini.test.javase.thread.threadpool;

import com.sun.org.apache.xpath.internal.functions.FuncTrue;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

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
        //起因  jdk.1.8
        /**
         * 1、线程的创建和销毁都需要时间，当有大量的线程创建和销毁时，那么这些时间的消耗则比较明显，将导致性能上的缺失
         * 2、大量的线程创建、执行和销毁是非常耗cpu和内存的，还可能造成OOM
         * 3、大量的线程的创建和销毁很容易导致GC频繁的执行，从而发生内存抖动现象，而发生了内存抖动，对于移动端来说，最大的影响就是造成界面卡顿
         *  所以我们采用线程池对线程进行复用，減少线程的创建，就能解决上述的问题了,而且包括了定时执行、定期执行、线程中断等功能。
         */
        /**
         *
         * 创建+执行+销毁时间
         * 一个线程池包括以下四个基本组成部分：
         * 1、线程池管理器（ThreadPool）：用于创建并管理线程池，包括创建线程池，销毁线程池，添加新任务；
         * 2、工作线程（PoolWorker）：线程池中线程，在没有任务时处于等待状态，可以循环的执行任务；
         * 3、任务接口（Task）：每个任务必须实现的接口，以供工作线程调度任务的执行，它主要规定了任务的入口，任务执行完后的收尾工作，任务的执行状态等；
         * 4、任务队列（taskQueue）：用于存放没有处理的任务。提供一种缓冲机制。
         */
        // 1 初始化
        /**
         * 阻塞队列：用于多线程共享数据
         * 这个队列用于持有操作线程。
         */
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        //ThreadPoolExecutor 线程池
        /**
         * 父类：AbstractExecutorService，AbstractExecutorService实现了ExecutorService接口,而ExecutorService继承Executor接口
         * Executor：接口里定义了一个接受Runnable的方法，
         * ExecutorService：提供了一些异步任务的操作(控制线程的最大并发数、线程的定时任务、单线程的顺序执行等)，并返回一些异步操作的结果{@code Future}；
         * AbstractExecutorService:ExecutorService的具体实现类
         *
         * 一些全局变量：
         *  workerCount：工作线程数
         *  runState:表示线程池运行，关闭等状态(RUNNING,SHUTDOWN,STOP,TIDYING,TERMINATED)
         *
         *  RUNNING：可接收新任务和执行等待队列里的任务
         *  SHUTDOWN：不可接收新任务，可执行等待队列里的任务
         *  STOP：不可接收新任务，不可执行等待队列里的任务，并且尝试终止所有在运行任务
         *  TIDYING：所有任务已经终止，执行terminated()
         *  TERMINATED：terminated()执行完成
         *
         *  线程池用一个32位的int来同时保存runState和workerCount，其中高3位是runState，其余29位是workerCount。通过runStateOf和workerCountOf来获取runState和workerCount。
         *  所以对runState值要进行左移操作29位,workerCount后面直接加1就行了。
         *  获取workerCount和runState的值
         * private static int runStateOf(int c)     { return c & ~CAPACITY; }高3位
         * private static int workerCountOf(int c)  { return c & CAPACITY; }低29位
         *
         *
         *  Worker类负责执行任务，Worker继承了AbstractQueuedSynchronizer，引出了Java并发框架的核心AQS。
         *  AbstractQueuedSynchronizer，简称AQS，是Java并发包里一系列同步工具的基础实现，原理是根据状态位来控制线程的入队阻塞、出队唤醒来处理同步
         *
         *   运行的线程数:
         *   private final HashSet<Worker> workers = new HashSet<Worker>();
         *
         *   CAS原则:指的是现代 CPU 广泛支持的一种对内存中的共享数据进行操作的一种特殊指令。这个指令会对内存中的共享数据做原子的读写操作。
         *
         *  可重入锁：
         *  private final ReentrantLock mainLock = new ReentrantLock();
         *
         *
         */

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
        // 参数赋值
        /**
         *@param threadFactory 默认的线程工厂
         *@param handler 超过线程池和队列的最大值的时候通过handler触发RejectedExecutionException异常
         * this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
         * Executors.defaultThreadFactory(), defaultHandler);
         */
        //执行
        /**
         * 传进去的线程會在未來的某個時候被执行,这个任务可能在一个新的线程或者在一个存在的线程池里被执行。（ may execute in a new thread or in an existing pooled thread.）
         * 如果executor被关闭或者超过他的容量，抛出 RejectedExecution
         */
        Thread thread = new Thread(new QuequeTest());
        executor.execute(thread);
        // execute 方法
        /**
         *  1 如果工作线程小于corePoolSize，启动一个新线程，这个方法自动调用addWorker检查运行状态和workerCount;如果工作线程数大于等于corePoolSiz,会将这个任务添加到队列
         *  2 如果任务成功添加到队列，还需要仔细检查是否已经添加到了线程,不能添加是返回false；
         *  3 如果不能添加执行队列的任务，会尝试添加新的线程，如果添加失败，线程池可能被关闭或者饱和，因此会拒绝这个任务。
         */

        /**
         * ctl:AtomicInteger是在使用非阻塞算法实现并发控制，在一些高并发程序中非常适合，但并不能每一种场景都适合，不同场景要使用使用不同的数值类。
         * 就是保存：workerCount，runState的变量
         */
//        int c = ctl.get(); 获取当前的workerCount，runState的值
        /**
         * 1 当前工作线程小于corePoolSize马上创建线程并运行这个任务，而不会进行排队
         */
//        if (workerCountOf(c) < corePoolSize) { // 通过 workerCountOf计算当前工作线程是否小于corePoolSize
//         if (addWorker(command, true))//在addWorker里进行了相关的判定，然后判断是否start任务线程,都是通过Worker对Thread进行封装后的操作。
//                return;  //start成功后返回
//            c = ctl.get();//失败后执行
//        }
        /**
         * 2  当前工作线程是大于等于corePoolSize，那就把这个任务放入队列
         *       1、如果队列满了，并且正在运行的线程数 < maximumPoolSize，那么还是要创建线程并运行这个任务。
         *       2、如果队列满了，并且正在运行的线程数 >= maximumPoolSize，那么线程池就会调用handler里方法。
         *       采用LinkedBlockingDeque就不会出现队列满情况
         */
//        if (isRunning(c) && workQueue.offer(command)) {//isRunning(c)：判断线程池是否关闭，是否成功添加到workQueue
//            int recheck = ctl.get();//再次检查
//            if (!isRunning(recheck) && remove(command))//线程池关闭且
//                reject(command);//抛出RejectedExecutionException异常
//            else if (workerCountOf(recheck) == 0)
//                addWorker(null, false);
//        }
//        else if (!addWorker(command, false))
//            reject(command);//抛出RejectedExecutionException异常
        //当一个任务执行完后，会从队列取出下一个任务来执行

        /**
         * addWorker里用到了CAS操作;
         * addWorker方法有4种传参的方式：
         *　1 addWorker(command, true):线程数小于corePoolSize时，放一个需要处理的task进worker set。如果worker set长度超过corePoolSize，就返回false。
         *  2 addWorker(command, false):当队列被放满时，就尝试将这个新来的task直接放入worker set，而此时worker set 的长度限制是maximumPoolSize。如果线程池也满了的话就返回false。
         *　3 addWorker(null, false):放入一个空的task进set，比较的的长度限制是maximumPoolSize。这样一个task为空的worker在线程执行的时候会判断出后去任务队列里拿任务，这样就相当于世创建了一个新的线程，只是没有马上分配任务。
         *　4 addWorker(null, true):这个方法就是放一个null的task进set，而且是在小于corePoolSize时。实际使用中是在 prestartCoreThread() 方法。
         *  这个方法用来为线程池先启动一个worker等待在那边，如果此时set中的数量已经达到corePoolSize那就返回false，什么也不干。还有是 prestartAllCoreThreads() 方法
         *  ，准备corePoolSize个worker
         */

//    private boolean addWorker(Runnable firstTask, boolean core) {
//        retry:
//        for (;;) {
//            int c = ctl.get();
//            int rs = runStateOf(c);//获取线程池的状态
//
//            // Check if queue empty only if necessary.
        //rs >= SHUTDOWN:判断线程池是否关闭；
        //!(rs == SHUTDOWN && firstTask == null &&!workQueue.isEmpty()):线程池没有关闭，firstTask不等于null，workQueue没有元素

//            if (rs >= SHUTDOWN &&!(rs == SHUTDOWN && firstTask == null &&!workQueue.isEmpty()))
//                return false;//线程池关闭，停止等或者       线程池不在关闭状态，firstTask!=null，workQueue没有元素
//
//            for (;;) {
//                int wc = workerCountOf(c);
//                if (wc >= CAPACITY ||
//                        wc >= (core ? corePoolSize : maximumPoolSize))
//                    return false;
//                if (compareAndIncrementWorkerCount(c))
//                    break retry;
//                c = ctl.get();  // Re-read ctl
//                if (runStateOf(c) != rs)
//                    continue retry;
//                // else CAS failed due to workerCount change; retry inner loop
//            }
//        }
//
//        boolean workerStarted = false;
//        boolean workerAdded = false;
//        ThreadPoolExecutor.Worker w = null;
//        try {
//            w = new ThreadPoolExecutor.Worker(firstTask);
//            final Thread t = w.thread;
//            if (t != null) {
//                final ReentrantLock mainLock = this.mainLock;
//                mainLock.lock();
//                try {
//                    // Recheck while holding lock.
//                    // Back out on ThreadFactory failure or if
//                    // shut down before lock acquired.
//                    int rs = runStateOf(ctl.get());
//
//                    if (rs < SHUTDOWN ||
//                            (rs == SHUTDOWN && firstTask == null)) {
//                        if (t.isAlive()) // precheck that t is startable
//                            throw new IllegalThreadStateException();
//                        workers.add(w);
//                        int s = workers.size();
//                        if (s > largestPoolSize)
//                            largestPoolSize = s;
//                        workerAdded = true;
//                    }
//                } finally {
//                    mainLock.unlock();
//                }
//                if (workerAdded) {
//                    t.start();
//                    workerStarted = true;
//                }
//            }
//        } finally {
//            if (! workerStarted)
//                addWorkerFailed(w);
//        }
//        return workerStarted;
//    }
        //Worker 调用star方法后会执行run方法
        /** Delegates main run loop to outer runWorker  */
//        public void run() {
//            runWorker(this);
//        }
        // runWorker(this);
        // beforeExecute(wt, task);
        // afterExecute(task, thrown);
        //while循环条件：先取worker自己的task，如果没有，就是上面提到addWorker时task放null的那种，就调用getTask方法。

        /**
         *submit
         */
//        Future<?> funcTrue = executor.submit(thread);

        Future<?> funcTrue = executor.submit(() -> "hi beini");
        try {
            System.out.println("   " + funcTrue.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //在AbstractExecutorService类的方法里
//        public Future<?> submit(Runnable task) {
//            if (task == null) throw new NullPointerException();
//            RunnableFuture<Void> ftask = newTaskFor(task, null);
//            execute(ftask);
//            return ftask;
//        }


        /**
         * 用线程池工厂(@{@link Executors})创建实例，
         */
        /**
         * 固定线程数量的线程池，该线程池中的线程数量始终不变，即不会再创建新的线程，也不会销毁已经创建好的线程，自始自终都是那几个固定的线程在工作，
         * 所以该线程池可以控制线程的最大并发数。
         *假如有一个新任务提交时，线程池中如果有空闲的线程则立即使用空闲线程来处理任务，
         * 如果没有，则会把这个新任务存在一个任务队列中，一旦有线程空闲了，则按FIFO方式处理任务队列中的任务。
         */
        ExecutorService fixThradPool = Executors.newFixedThreadPool(5);
//        public static ExecutorService newFixedThreadPool(int nThreads) {
//            return new ThreadPoolExecutor(nThreads, nThreads,
//                    0L, TimeUnit.MILLISECONDS,
//                    new LinkedBlockingQueue<Runnable>());
//        }


        /**
         * 可以根据实际情况调整线程池中线程的数量的线程池。即该线程池中的线程数量不确定，是根据实际情况动态调整的。
         * 有新任务提交时就会创建一个线程去执行，为了避免线程池数目越来越多，默认设置了60L秒的保活时间。
         */
        ExecutorService newCacheThreadPool = Executors.newCachedThreadPool();

//        public static ExecutorService newCachedThreadPool() {
//            return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                    60L, TimeUnit.SECONDS,
//                    new SynchronousQueue<Runnable>());
//        }
        /**
         * 只能创建一个线程的线程池，即每次只能执行一个线程任务，多余的任务会保存到一个任务队列中，等待这个线程空闲，
         * 当这个线程空闲了再按FIFO方式顺序执行任务队列中的任务。
         */
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
//        public static ExecutorService newSingleThreadExecutor() {
//            return new Executors.FinalizableDelegatedExecutorService
//                    (new ThreadPoolExecutor(1, 1,
//                            0L, TimeUnit.MILLISECONDS,
//                            new LinkedBlockingQueue<Runnable>()));
//        }

        /**
         * 控制线程池内线程定时或周期性执行某任务的线程池
         */
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
//        public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
//            return new ScheduledThreadPoolExecutor(corePoolSize);
//        }
//        newScheduledThreadPool.schedule(command, 2000, TimeUnit.MILLISECONDS);//2000ms后执行
//        newScheduledThreadPool.scheduleAtFixedRate(command, 10, 1000, TimeUnit.MILLISECONDS);//延迟10ms后，每隔1000ms执行一次command

        /**
         * 可以控制线程池内线程定时或周期性执行某任务的线程池。只不过和上面的区别是该线程池大小为1，而上面的可以指定线程池的大小。
         */
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
//        public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
//            return new Executors.DelegatedScheduledExecutorService
//                    (new ScheduledThreadPoolExecutor(1));
//        }
        /**
         * executor.shutdown():等待提交的任务执行完成并不再接受新任务，在完成全部提交的任务后关闭
         * executor.shutdownNow():将强制终止所有运行中的任务并不再允许提交新任务
         */
        executor.shutdown();
    }
}
