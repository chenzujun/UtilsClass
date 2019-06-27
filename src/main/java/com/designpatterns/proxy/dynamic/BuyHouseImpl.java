package com.designpatterns.proxy.dynamic;

/**
 * @author chenjun
 * @date 2019/6/27
 * @since V1.0.0
 */
public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHosue() {
        System.out.println("我要买房");
    }

    @Override
    public void move() {
        System.out.println("搬迁");
    }
}
