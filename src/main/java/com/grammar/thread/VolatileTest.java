package com.grammar.thread;

/**
 * @description: volatile Fields 为什么偶尔是j>i
 * @author: mustang
 * @create: 2018-12-23
 **/
public class VolatileTest {
    static int i = 0, j = 0;
    static void one() { i++; j++; }
    static void two() {
        if(i != j){
            System.out.println("i="+i + " j=" + j);
        }
    }
    public static void main(String[] args) {
        while (true) {
            new Thread(){
                public void run(){
                    VolatileTest.one();
                }
            }.start();

            new Thread(){
                public void run(){
                    VolatileTest.two();
                }
            }.start();
        }
    }
}
