package com.designpatterns.combination;

import java.util.Iterator;

/**
 * @author chenjun
 * @date 2019/6/17
 * @since V1.0.0
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
