package com.designpatterns.factory.method;

public abstract class Pizza {
    String name;

    void prepare(){
        System.out.println("prepare "+name);
    }
    void bake(){
        System.out.println("bake for 25 minutes at 350");
    }
    void cut(){
        System.out.println("cutting the pizza into diagonal slices");
    }
    void box(){
        System.out.println("place pizza in official PiazzaStore box");
    }
}
