package com.designpatterns.template;

/**
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public abstract class AbstractClass {

    void templateMethod(){
        operation1();
        operation2();
        concreteOperation();
        hook();
    }

    abstract void operation1();
    abstract void operation2();

    void concreteOperation(){
        System.out.println("模板实现 concreteOperation");
    }

    void hook(){}
}
