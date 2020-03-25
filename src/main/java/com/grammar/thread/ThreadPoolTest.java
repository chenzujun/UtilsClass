package com.grammar.thread;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ThreadPoolTest {

    /**
     * 缺点：线程最大数为Integer.MAX_VALUE
     */
    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 40, 5,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());

    /**
     * 创建一个单线程化的线程池
     */
    public static  ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行——延迟执行
     */
    public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

}
