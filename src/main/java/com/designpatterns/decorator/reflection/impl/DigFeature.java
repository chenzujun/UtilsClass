package com.designpatterns.decorator.reflection.impl;

import com.designpatterns.decorator.reflection.Feature;

/**
 * 钻地的能力
 *
 * @author chenjun
 * @date 2020/4/20
 * @since V1.0.0
 */
public class DigFeature implements Feature {
    @Override
    public void load() {
        System.out.println("爪子升级，能够钻地了》》》》》》》》");
    }
}
