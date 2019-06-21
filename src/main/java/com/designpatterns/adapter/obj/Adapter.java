package com.designpatterns.adapter.obj;

/**
 * 适配器
 *
 * @author chenjun
 * @date 2019/6/21
 * @since V1.0.0
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter (Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void request() {
        this.adaptee.specialRequest();
    }
}
