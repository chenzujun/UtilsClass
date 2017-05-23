package com.grammar.array;

public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 静态初始化
		String[] books = new String[]{
				"java讲义",
				"web实战"
		};
		String[] names = {"腻歪","野马"};
		
		// 动态初始化
		String[] strArr = new String[5];
		
		
		System.out.println("books length:"+books.length);
		System.out.println("names:"+names.length);
		System.out.println("strArr length:"+strArr.length);
		
		// 默认值false
		boolean[] booArr = new boolean[2];
		System.out.println("booArr first:"+booArr[1]);
		
		
	}

}
