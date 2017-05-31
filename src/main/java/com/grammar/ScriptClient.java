package com.grammar;

import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class ScriptClient<T> {

    public static void main(String[] args) {
        ScriptEngine s = new ScriptEngineManager().getEngineByName("javascript");

        new ScriptClient<String>().test("");
            
    }
    
    public void test(T t){
        System.out.println(t instanceof Date);
    }
    
    static void saveDefault(){
        System.out.println("savedefault");
    }
    
    static void save(int fee){
        System.out.println("save");
    }
}
