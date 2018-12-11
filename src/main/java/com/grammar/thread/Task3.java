package com.grammar.thread;

public class Task3 implements Runnable {

	boolean running = false;
	int i = 0;
	
	public void run() {
		while(this.isRunning()) {
			i++;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Task3 r1 = new Task3();
		Thread t1 = new Thread(r1);
		t1.start();


		Task3 r2 = new Task3();
		Thread t2 = new Thread(r2);
		t2.start();

		r1.setRunning(true);
		Thread.sleep(100);

		System.out.println(r1.i+"程序停止"+r1.running);
		System.out.println(r2.i+"程序停止"+r2.running);
		Thread.sleep(50);
		System.exit(0);
		
	}
	
	public synchronized boolean isRunning() {
		return running;
	}
	
	public synchronized void setRunning(boolean running) {
		this.running = running;
	}
}
