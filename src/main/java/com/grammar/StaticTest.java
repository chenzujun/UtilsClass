package com.grammar;

public class StaticTest
{
    public static void main(String[] args)
    {
        staticFunction();
    }
 
    static StaticTest st = new StaticTest();
 
    static
    {
        System.out.println("1");
    }
 
    {
        System.out.println("2");
    }
 
    int a=110;
    static int b =112;
    
    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
        b=10;
        System.out.println("StaticTest,b="+b);
    }
 
    public static void staticFunction(){
        System.out.println(b);
    }
 
    
}