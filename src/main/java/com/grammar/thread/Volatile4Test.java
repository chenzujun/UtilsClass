package com.grammar.thread;

/**
 * @description: 可能会输出多次，还未见到多次情况
 * @author: mustang
 * @create: 2018-12-23
 **/
public class Volatile4Test implements Runnable {
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            Thread t = new Thread(new Volatile4Test());
            t.start();
        }
    }

    @Override
    public void run() {
        // 这里设置一个Flag，如果有线程执行，那么更改flag阻止其他线程打印。
        if (flag) {
            flag = false;
            System.out.println("我打印了！");
        }
    }
}
