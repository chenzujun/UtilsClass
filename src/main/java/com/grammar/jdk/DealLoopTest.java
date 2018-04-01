package com.grammar.jdk;

public class DealLoopTest {

	static class DeadLoopClass {
		static {
			if (true) {
				System.out.println(Thread.currentThread() + " init DeadLoopClass");
				// 耗时很长的操作，导致线程卡死
				while (true) {
				}
			}
		}
	}

	public static void main(String[] args) {
		Runnable script = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread() + " start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(dlc);
				System.out.println(Thread.currentThread() + " run over");
			}
		};

		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}