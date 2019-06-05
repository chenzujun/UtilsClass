package com.designpatterns.chain;

/**
 * @author chenjun
 * @date 2019/6/5
 * @since V1.0.0
 */
public abstract class Handler {


    public final void handleMessage(){

    }

    protected abstract boolean response();

}
