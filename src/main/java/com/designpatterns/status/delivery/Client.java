package com.designpatterns.status.delivery;

/**
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        context.delivery();
        context.sign();
    }
}
