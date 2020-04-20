package com.designpatterns.decorator.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * 反射装饰实现
 *
 * @author chenjun
 * @date 2020/4/20
 * @since V1.0.0
 */
public class DecorateAnimal implements Animal {

    private Animal animal;
    private Class<? extends Feature> clz;

    public DecorateAnimal(Animal animal, Class<? extends Feature> clz) {
        this.animal = animal;
        this.clz = clz;
    }

    @Override
    public void doSomething() {
        InvocationHandler handler = (Object proxy, Method method, Object[] args)-> {
            Object obj = null;
            if(Modifier.isPublic(method.getModifiers())){
                obj = method.invoke(clz.newInstance(), args);
            }
            animal.doSomething();
            return obj;
        };

        ClassLoader cl = getClass().getClassLoader();
        Feature proxy = (Feature)Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
        proxy.load();
    }
}
