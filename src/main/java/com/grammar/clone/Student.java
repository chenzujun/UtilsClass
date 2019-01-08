package com.grammar.clone;

import java.io.*;

public class Student implements Cloneable ,Serializable{

	private static final long serialVersionUID = 4219007454757068005L;
	
	private String name;
    private transient int age;
    private Book book;

    //浅克隆
    public Student clone(){
        Student stu = null;
        try {
            stu = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }

    //深克隆
    public Student deepClone() throws Exception {
        Student stu = null;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bo);
        oos.writeObject(this);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        stu = (Student) oi.readObject();
        return stu;
    }


    public Student(String name, int age, Book book) {
        this.name = name;
        this.age = age;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}