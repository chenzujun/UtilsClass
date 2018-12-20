package com.grammar.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计数线程：原子性
 *
 * @author chenjun
 * @date 2018/12/11
 * @since V1.0.0
 */
public class CounterAtomThread {
    /**
     *  使用原子操作类
     */
    public static AtomicInteger num = new AtomicInteger(0);
    /**
     * 使用CountDownLatch来等待计算线程执行完
     */
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
//        int a= num.incrementAndGet();
//        System.out.println("return value="+a+" | real value="+num);

        //开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            new Thread(){
                public void run(){
                    for(int j=0;j<1000;j++){
                        //原子性的num++,通过循环CAS方式
                       num.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num);
    }
}
