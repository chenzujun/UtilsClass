package com.designpatterns.status;

/**
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLinkState(Context.carryingState);
        context.carry();
        context.ignite();
        context.put();
        context.goaway();
        context.ignite();
    }
}
