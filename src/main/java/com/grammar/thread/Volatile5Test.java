package com.grammar.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description: Volatile4Test完善
 * @author: mustang
 * @create: 2018-12-23
 **/
public class Volatile5Test implements Runnable {
    private static AtomicBoolean atomicFlag = new AtomicBoolean(true);

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            Thread t = new Thread(new Volatile5Test());
            t.start();
        }
    }

    public void run() {
        if (atomicFlag.compareAndSet(true,false)) {
            System.out.println("我打印了！");
        }
    }
}
