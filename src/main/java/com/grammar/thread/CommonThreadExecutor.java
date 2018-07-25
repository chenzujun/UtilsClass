package com.grammar.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
public class CommonThreadExecutor {
    private static ExecutorService synExe = null;

    static {
        // 允许有线程一直驻留在线程池中，短时间会有任务使用线程
        int threadSize = Runtime.getRuntime().availableProcessors() * 2;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2000);
        synExe = new ThreadPoolExecutor(threadSize, 100, 5L, TimeUnit.MINUTES, workQueue,
                new BasicThreadFactory.Builder().namingPattern("CommonThreadExecutor").build());
    }

    public static void execute(Runnable run) {
        synExe.execute(run);
    }
}
