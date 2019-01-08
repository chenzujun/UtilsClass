package com.grammar.clone;

public class Client {
	public static void main(String[] args) {
		Book book = new Book("Chinese");
		Student s = new Student("Tom", 12, book);
		Student s1 = s.clone();

		System.out.println(s == s1);
		System.out.println(s.getClass() == s1.getClass());
		System.out.println(s.getBook() == s1.getBook());

		System.out.println("------------------------");

		try {
			Student s2 = s.deepClone();

			System.out.println(s == s2);
			System.out.println(s.getClass() == s2.getClass());
			System.out.println(s.getBook() == s2.getBook());

			System.out.println("-------------------");
			System.out.println("s.age:" + s.getAge() + " s2.age:" + s2.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
