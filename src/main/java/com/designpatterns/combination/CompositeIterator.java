package com.designpatterns.combination;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author chenjun
 * @date 2019/6/17
 * @since V1.0.0
 */
public class CompositeIterator implements Iterator {
    private Stack stack = new Stack();
    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        }else {
            Iterator iterator = (Iterator)stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }else {
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if(hasNext()){
            Iterator iterator = (Iterator)stack.peek();
            MenuComponent component = (MenuComponent)iterator.next();
            if(component instanceof Menu){
                stack.push(component.creatIterator());
            }
            return component;
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
