package com.grammar.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计数线程
 *
 * @author chenjun
 * @date 2018/12/11
 * @since V1.0.0
 */
public class CounterThread {
    public static int num = 0;

    /**
     *  使用原子操作类
     */
    public static AtomicInteger numAtom = new AtomicInteger(0);

    /**
     * 使用CountDownLatch来等待计算线程执行完
     */
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    static CountDownLatch countDownLatch2 = new CountDownLatch(30);

    public static void counter() throws Exception {
        long start = System.currentTimeMillis();
        // 开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            CommonThreadExecutor.execute(()->{
                synchronized (CounterThread.class){
                    for(int j=0;j<10000000;j++){
                        // 1.读取 2.加一 3.赋值
                        num++;
                    }
                }
                countDownLatch.countDown();
            });
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println("end:"+num + " | 耗时="+(System.currentTimeMillis()-start));
    }

    public static void counterAtom() throws Exception {
        long start = System.currentTimeMillis();
        // 开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            CommonThreadExecutor.execute(()->{
                for(int j=0;j<10000000;j++){
                    //原子性的num++,通过循环CAS方式
                    numAtom.incrementAndGet();
                }
                countDownLatch2.countDown();
            });
        }
        //等待计算线程执行完
        countDownLatch2.await();
        System.out.println("atom end:"+numAtom + " | 耗时="+(System.currentTimeMillis()-start));
    }

    public static void main(String []args) throws Exception {
        counter();
        counterAtom();
    }
}
