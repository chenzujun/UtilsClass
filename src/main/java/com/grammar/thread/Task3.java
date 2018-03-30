package com.grammar.thread;

public class Task3 implements Runnable {

	boolean running = true;
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
		Thread.sleep(10);
		r1.running = false;
		System.out.println(r1.i);
		System.out.println("程序停止");
		
	}
	
	public synchronized boolean isRunning() {
		return running;
	}
	
	public synchronized void setRunning(boolean running) {
		this.running = running;
	}
}
