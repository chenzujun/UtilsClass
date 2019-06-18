package com.designpatterns.combination;

import java.util.Iterator;

/**
 * 菜单组件
 *
 * @author chenjun
 * @date 2019/6/14
 * @since V1.0.0
 */
public abstract class MenuComponent {

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    public abstract Iterator creatIterator();
}
