package com.grammar.thread;

/**
 * a、b修改同时成功
 *
 * @author chenjun
 * @date 2018/12/20
 * @since V1.0.0
 */
public class Volatile6Test {
    int a = 1;
    int b = 1;

    public synchronized void change(){
        a = 3;
        b = a;
    }

    public void print(){
        System.out.println(b+"="+a);
    }

    public static void main(String[] args) {
        while (true){
            final Volatile6Test test = new Volatile6Test();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();

        }
    }
}