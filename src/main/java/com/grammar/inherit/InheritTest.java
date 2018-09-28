package com.grammar.inherit;

import com.grammar.inherit.in.Tiger;

/**
 * @author chenjun
 * @date 2018/9/28
 * @since V1.0.0
 */
public class InheritTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal tiger = new Tiger();

        System.out.println(animal.name);
        animal.call();
        Animal.eat();

        System.out.println(tiger.name);
        tiger.call();
        Tiger.eat();
    }
}
