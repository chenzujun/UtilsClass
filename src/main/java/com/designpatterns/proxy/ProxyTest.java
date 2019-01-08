package com.designpatterns.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Subject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
	}
}
