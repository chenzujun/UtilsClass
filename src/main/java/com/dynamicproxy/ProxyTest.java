package com.dynamicproxy;

public class ProxyTest {
	public static void main(String[] args) {
        Service service = new UserServiceImpl();
        MyInvocatioHandler handler = new MyInvocatioHandler(service);
        Service serviceProxy = (Service)handler.getProxy();
        serviceProxy.add();
        
        
        Employee e = new Manager();
        MyInvocatioHandler handler2 = new MyInvocatioHandler(e);
        Employee eProxy = (Employee)handler2.getProxy();
        eProxy.getName();
    }
}