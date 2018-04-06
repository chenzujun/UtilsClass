package com.grammar.inherit;

public class Parent {

	public static final void staticTest(){
		System.out.println("父类的静态方法被调用");
	}
	
	public void test(){
		System.out.println("父类普通方法");
	}

	@Override
	public String toString() {
		return "Parent [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
