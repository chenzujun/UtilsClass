package com.grammar.random;

import java.util.Random;

public class RandomTest {

	public static void getRandomInt(){
		Random random = new Random();
		System.out.println(random.nextInt(1));
	}
	
	public static void test(){
		for (int i = 0; i < 10000; i++) {
			i = i+1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("begin");
		getRandomInt();
		System.out.println("end");
	}
}
