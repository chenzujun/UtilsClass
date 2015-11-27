package com.grammar.thread;

public class MyRunnable implements Runnable {

	private String name;
	
	public MyRunnable(String name){
		this.name=name;
	}
	
	public void run() {
		for (int i = 0; i < 11; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(name + ":" + i);
		}

	}

	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable("runnable");
		MyRunnable r2 = new MyRunnable("runnable");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t2.start();
		t1.start();
	}
}
