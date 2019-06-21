package com.designpatterns.adapter.kind;

/**
 * 类的适配器
 *
 * @author chenjun
 * @date 2019/6/21
 * @since V1.0.0
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        this.specialRequest();
    }
}
