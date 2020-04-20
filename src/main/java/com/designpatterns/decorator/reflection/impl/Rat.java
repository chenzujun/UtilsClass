package com.designpatterns.decorator.reflection.impl;

import com.designpatterns.decorator.reflection.Animal;

/**
 * 大老鼠实现类
 *
 * @author chenjun
 * @date 2020/4/20
 * @since V1.0.0
 */
public class Rat implements Animal {

    @Override
    public void doSomething() {
        System.out.println("Tom behind me! help ...");
    }

}
