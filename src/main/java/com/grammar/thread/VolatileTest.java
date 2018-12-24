package com.grammar.thread;

/**
 * @description: volatile Fields
 * @author: mustang
 * @create: 2018-12-23
 **/
public class VolatileTest {
    static int i = 0, j = 0;
    static void one() {
        i++;
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        j++;
    }
    static void two() {
        System.out.println("i="+i + " j=" + j + " time="+System.currentTimeMillis());
    }
    public static void main(String[] args) {
        System.out.println("i="+i + " j=" + j + " time="+System.currentTimeMillis());
        new Thread(){
            public void run(){
                VolatileTest.one();
            }
        }.start();

        while (true) {
            new Thread(){
                public void run(){
                    VolatileTest.two();
                }
            }.start();
        }
    }
}
