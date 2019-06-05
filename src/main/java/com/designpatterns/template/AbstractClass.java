package com.designpatterns.template;

/**
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public abstract class AbstractClass {

    public final void templateMethod(){
        operation1();
        if(hook()){
            operation2();
        }
        concreteOperation();
    }

    protected abstract void operation1();

    protected abstract void operation2();

    void concreteOperation(){
        System.out.println("模板实现 concreteOperation");
    }

    boolean hook(){
        return true;
    }

}
