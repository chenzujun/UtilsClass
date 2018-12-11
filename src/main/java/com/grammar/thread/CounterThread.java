package com.grammar.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 计数线程
 *
 * @author chenjun
 * @date 2018/12/11
 * @since V1.0.0
 */
public class CounterThread {
    public static volatile int num = 0;
    /**
     * 使用CountDownLatch来等待计算线程执行完
     */
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            new Thread(){
                public void run(){
                    for(int j=0;j<10000;j++){
//                        1.读取
//                        2.加一
//                        3.赋值
                        num++;
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
