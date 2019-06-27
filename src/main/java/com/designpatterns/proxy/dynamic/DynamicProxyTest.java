package com.designpatterns.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author chenjun
 * @date 2019/6/27
 * @since V1.0.0
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        proxyBuyHouse.buyHosue();
        proxyBuyHouse.move();
    }
}
