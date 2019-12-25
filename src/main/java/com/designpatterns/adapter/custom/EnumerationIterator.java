package com.designpatterns.adapter.custom;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author chenjun
 * @date 2019/12/16
 * @since V1.0.0
 */
public class EnumerationIterator implements Iterator {
    Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    public static void main(String[] args) {
        String[] data = new String[4];
        data[0] = "tiger";
        data[1] = "monkey";
        data[2] = "cat";
        data[3] = "snake";
        MyEnumeration myEnumeration = new MyEnumeration(0, 4, data);
        while (myEnumeration.hasMoreElements()){
            System.out.println(myEnumeration.nextElement());
        }

        MyEnumeration myEnumeration2 = new MyEnumeration(0, 4, data);
        Iterator it = new EnumerationIterator(myEnumeration2);
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // JAVA8写法
        MyEnumeration myEnumeration3 = new MyEnumeration(0, 4, data);
        Iterator it2 = new EnumerationIterator(myEnumeration3);
        it2.forEachRemaining(str->System.out.println(str));
    }

}
