package com.designpatterns.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 其原理是通过字节码技术为一个类创建子类，
 * 并在子类中采用方法拦截的技术拦截所有父类方法的调用，
 * 顺势织入横切逻辑。但因为采用的是继承，所以不能对final修饰的类进行代理
 *
 * @author chenjun
 * @date 2019/6/27
 * @since V1.0.0
 */
public class CglibProxy implements MethodInterceptor {

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }

    private void before() {
        System.out.println(" before ");

    }

    private void after() {
        System.out.println(" after ");
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CglibProxy cGlibProxy = new CglibProxy();
        BuyHouseImpl buyHouse = cGlibProxy.getProxy(BuyHouseImpl.class);
        buyHouse.buyHosue();

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
