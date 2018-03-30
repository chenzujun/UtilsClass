package com.grammar.thread;

public class Task implements Runnable {

	boolean running = true;
	int i = 0;
	
	public void run() {
		while(running) {
			i++;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Task r1 = new Task();
		Thread t1 = new Thread(r1);
		t1.start();
		Thread.sleep(10);
		r1.running = false;
		Thread.sleep(100);
		System.out.println(r1.i);
		System.out.println("程序停止"+r1.running);
		
		
		Task r2 = new Task();
		Thread t2 = new Thread(r2);
		t2.start();
		System.out.println(r2.i);
		System.out.println("程序停止"+r2.running);
		
	}
}