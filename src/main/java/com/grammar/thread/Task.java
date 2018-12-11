package com.grammar.thread;

public class Task implements Runnable {

	boolean running = false;
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

		
		Task r2 = new Task();
		Thread t2 = new Thread(r2);
		t2.start();

		r1.running = true;
		Thread.sleep(30);
		System.out.println(r1.i+"程序停止"+r1.running);
		System.out.println(r2.i+"程序停止"+r2.running);
		System.exit(0);
	}
}
