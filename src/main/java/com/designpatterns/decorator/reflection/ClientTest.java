package com.designpatterns.decorator.reflection;

import com.designpatterns.decorator.reflection.impl.DigFeature;
import com.designpatterns.decorator.reflection.impl.FlyFeature;
import com.designpatterns.decorator.reflection.impl.Rat;

/**
 * @author chenjun
 * @date 2020/4/20
 * @since V1.0.0
 */
public class ClientTest {
    public static void main(String[] args) {
        Animal jerry = new Rat();
        jerry = new DecorateAnimal(jerry, FlyFeature.class);
        jerry = new DecorateAnimal(jerry, DigFeature.class);
        jerry.doSomething();
    }
}
