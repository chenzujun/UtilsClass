package com.grammar.thread;

/**
 * @description: volatile Fields
 * @author: mustang
 * @create: 2018-12-23
 **/
public class Volatile2Test {
    static int i = 0, j = 0;
    static synchronized void one() { i++; j++; }
    static synchronized void two() {
        System.out.println(i + "=" + j);
    }
    public static void main(String[] args) {
        while (true) {
            new Thread(){
                public void run(){
                    Volatile2Test.one();
                }
            }.start();

            new Thread(){
                public void run(){
                    Volatile2Test.two();
                }
            }.start();
        }
    }
}
