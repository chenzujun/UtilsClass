package com.grammar.random;

import java.util.Random;

public class RandomTest {

	public static void getRandomInt(){
		Random random = new Random();
		
		System.out.println(random.nextInt(1));
		System.out.println(random.nextInt(2));
		System.out.println(random.nextInt(2));
		System.out.println(random.nextInt(2));
	}
	
	public static void main(String[] args) {
		getRandomInt();
	}
}
