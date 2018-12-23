package com.grammar.thread;

/**
 * @description: volatile Fields
 * @author: mustang
 * @create: 2018-12-23
 **/
public class Volatile3Test {
    static volatile int i = 0, j = 0;
    static void one() { i++; j++; }
    static void two() {
        System.out.println(i + "=" + j);
    }
    public static void main(String[] args) {
        while (true) {
            new Thread(){
                public void run(){
                    Volatile3Test.one();
                }
            }.start();

            new Thread(){
                public void run(){
                    Volatile3Test.two();
                }
            }.start();
        }
    }
}
