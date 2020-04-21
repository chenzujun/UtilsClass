package com.designpatterns.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author chenjun
 * @date 2019/6/27
 * @since V1.0.0
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        BuyHouse buyHouse = new BuyHouseImpl();
        // Class 类的描述
        // new Class[]{BuyHouse.class} 当个接口描述放入数组
        // 或
        // BuyHouseImpl.class.getInterfaces() 此类直接实现的接口对象数组
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        proxyBuyHouse.buyHosue();
        proxyBuyHouse.move();

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
