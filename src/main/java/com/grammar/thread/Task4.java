package com.grammar.thread;

/**
 * @author chenjun
 * @date 2018/12/11
 * @since V1.0.0
 */
public class Task4 implements Runnable {
    int a = 1;
    boolean status = false;

    /**
     * 状态切换为true
     */
    public void changeStatus(){
        status = true;
        a = 2;

    }

    /**
     * 若状态为true，则running。
     */
    @Override
    public void run(){
        if(status){
            int b = a+1;
            System.out.println(Thread.currentThread()+"="+b);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task4 r1 = new Task4();
        Thread t1 = new Thread(r1);

        t1.start();
        r1.changeStatus();
        Thread.sleep(10);
    }
}
