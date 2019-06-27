package com.designpatterns.proxy;

/**
 * 静态代理：可以做到在符合开闭原则的情况下对目标对象进行功能扩展
 */
public class ProxyTest {

	public static void main(String[] args) {
		Subject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
	}
}
