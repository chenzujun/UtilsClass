package com.inherit;

public class Children extends Parent {

	public void test(){
		System.out.println("父类普通方法");
	}
	
	public static void main(String[] args) {
		Children c = new Children();

		Children.staticTest();
		c.test();
	}
}
