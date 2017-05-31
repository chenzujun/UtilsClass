package com.grammar.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    public static void testListRemove() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(22));
        list.add(new Integer(333));

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int in = (Integer) iter.next();
            if (22 == in) {
                iter.remove();
            }
            System.out.println(in);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }


    public static void main(String[] args) {
        testListRemove();
    }
}
