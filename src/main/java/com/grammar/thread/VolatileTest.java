package com.grammar.thread;

/**
 * @description: volatile Fields 为什么偶尔是j>i
 * @author: mustang
 * @create: 2018-12-23
 **/
public class VolatileTest {
    static int i = 0, j = 0;
    static volatile int i2 = 0, j2 = 0;

    static void one() {
        i++;
        j++;
    }
    static void two() { i2++; j2++; }
    static void three() {
        if(i != j){
            System.out.println("i="+i + " j=" + j + " time="+System.currentTimeMillis());
        }
        if(i2 != j2){
            System.out.println("i2="+i2 + " j2=" + j2 + " time="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        System.out.println("i="+i + " j=" + j + " time="+System.currentTimeMillis());
        System.out.println("i2="+i2 + " j2=" + j2 + " time="+System.currentTimeMillis());

        ThreadPoolTest.cachedThreadPool.execute(()->{
            VolatileTest.one();
            VolatileTest.two();
        });
        int g=1000;
        while (g>0) {
            ThreadPoolTest.cachedThreadPool.execute(()->{
                VolatileTest.three();
            });
            g--;
        }
        ThreadPoolTest.cachedThreadPool.shutdown();
    }
}
