package com.grammar.inherit;

public class Children extends Parent {

	
	public void test() {
		System.out.println("子类普通方法");
	}

	public Children() {
		System.out.println("狗可以吠叫");
	}

	public static void main(String[] args) {
		Children c = new Children();

		Children.staticTest();
		c.test();
	}
}
