package com.thread;

public class Singleton {

	private static Singleton s = new Singleton();
	
	public static int count1;
	public static int count2=0;
	
	static {
		count1++;
		count2++;
	}
	
	public Singleton(){
		count1++;
		count2++;
	}
	
	public static Singleton getSingleton(){
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton.count1);
		System.out.println(Singleton.count2);
	}
}