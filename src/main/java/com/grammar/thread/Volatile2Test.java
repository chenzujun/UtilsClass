package com.grammar.thread;

/**
 * @description: volatile Fields
 * @author: mustang
 * @create: 2018-12-23
 **/
public class Volatile2Test {
    static int i = 0, j = 0;
    static synchronized void one() {
        i++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }
    static synchronized void two() {
        if(i != j){
            System.out.println("i="+i + " j=" + j +"two start time="+System.currentTimeMillis());
        }
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
