package com.grammar.thread;

public class MyThread extends Thread {

	
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName()+":"+i);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		
		t1.start();
		t2.start();
	}
	
}
