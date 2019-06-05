package com.designpatterns.template.impl;

import com.designpatterns.template.AbstractClass;

/**
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public class ConcreteClass extends AbstractClass {

    @Override
    protected void operation1(){
        System.out.println("operation1");
    }

    @Override
    protected void operation2(){
        System.out.println("operation2");
    }

    boolean hook(){
        return false;
    }
}
