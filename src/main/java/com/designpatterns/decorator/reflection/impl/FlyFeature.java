package com.designpatterns.decorator.reflection.impl;

import com.designpatterns.decorator.reflection.Feature;

/**
 * 飞行的能力
 *
 * @author chenjun
 * @date 2020/4/20
 * @since V1.0.0
 */
public class FlyFeature implements Feature {
    @Override
    public void load() {
        System.out.println("增加翅膀》》》》》》》》");
    }
}
