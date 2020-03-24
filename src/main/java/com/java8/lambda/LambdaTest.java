package com.java8.lambda;

/**
 * Lambda表达式
 *
 * @author chenjun
 * @date 2018/6/14
 * @since V1.0.0
 */
public class LambdaTest {
    public static void useTest(){
        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        });
        td.start();


    }
}
