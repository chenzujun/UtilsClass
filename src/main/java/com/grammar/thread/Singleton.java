package com.grammar.thread;

public class Singleton {

    private static Singleton s = new Singleton();

    public static int count1;
    public static int count2 = 0;

    static {
        System.out.println("count1 in static=" + count1);
        System.out.println("count2 in static=" + count2);
        count1++;
        count2++;
    }

    public Singleton() {
        count1++;
        count2++;
        System.out.println("count1 in constructor=" + count1);
        System.out.println("count2 in constructor=" + count2);
    }

    public static Singleton getSingleton() {
        System.out.println("count1 in getSingleton=" + count1);
        System.out.println("count2 in getSingleton=" + count2);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.count1);
        System.out.println(Singleton.count2);
    }
}