package com.grammar.array;


public class ForTest {
    public static void main(String[] args) {
        int count =0;
        int j=0;
        for (int i=0;i<10;i++) {
            count=count++;
            
            System.out.println("for=count|"+count);
        }
        System.out.println(count);
        
    }
}
