package com.grammar.thread;

public class Task2 implements Runnable {

	volatile boolean running = true;
	int i = 0;
	
	public void run() {
		while(running) {
			i++;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Task2 r1 = new Task2();
		Thread t1 = new Thread(r1);
		t1.start();
		Thread.sleep(10);
		r1.running = false;
		System.out.println(r1.i);
		System.out.println("程序停止");
		
	}
}
