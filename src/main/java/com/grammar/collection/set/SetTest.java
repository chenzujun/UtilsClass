package com.grammar.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SetTest {

    public static void testSetRemove() {
        Set<Integer> set = new HashSet<Integer>();
        set.add(new Integer(1));
        set.add(new Integer(22));
        set.add(new Integer(333));
        set.add(null);

        System.out.println(set.size());

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int in = (Integer) iter.next();
            if (22 == in) {
                iter.remove();
            }
        }

        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        testSetRemove();
    }
}
