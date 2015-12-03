package com.grammar.random;

import java.util.Random;

public class RandomTest {
	private static int a = 0;//65<
	private static int b = 0;//35
	private static int c = 0;//5
	
	public static void getRandomInt(){
		Random random = new Random();
		System.out.println(random.nextInt(1));
	}
	
	public static void test(){
		for (int i = 0; i < 30; i++) {
			int r = getRandom(100);
			if(r<65){
				a++;
			}else if(r<95){
				b++;
			}else {
				c++;
			}
		}
	}
	
	private static int getRandom(int limit){
		if(limit<=0 || limit >100){
			limit = 100;
		}
		Random random = new Random();
		return random.nextInt(limit)+1;
	}
	
	public static void main(String[] args) {
		test();
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
}
