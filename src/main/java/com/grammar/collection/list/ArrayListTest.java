package com.grammar.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    public static void testListRemove() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        //正常循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));
        }
        System.out.println("没有remove前list的项:" + list.size());

        //边循环边删除
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));
            //删除list的第四项
            if (list.get(i) == 3) {
                list.remove(list.get(i));
            }
        }
        System.out.println("remove后list的项:" + list.size());

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer v = it.next();
            if(3 == v){
                it.remove();
            }
        }

        System.out.println("==========remove后的list==========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));
        }

    }


    public static void main(String[] args) {
        testListRemove();
    }
}
