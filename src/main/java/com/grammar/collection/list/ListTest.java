package com.grammar.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    /**
     * 数组的初始化方式
     */
    public static void testInit(){
        // 静态初始化
        String[] books = new String[]{
                "java讲义",
                "web实战"
        };
        String[] names = {"腻歪", "野马"};

        // 动态初始化
        String[] strArr = new String[5];

        System.out.println("books length:" + books.length);
        System.out.println("names:" + names.length);
        System.out.println("strArr length:" + strArr.length);

        // 默认值false
        boolean[] booArr = new boolean[2];
        System.out.println("booArr first:" + booArr[1]);
    }

    /**
     * subList是浅拷贝
     * addAll是深拷贝
     */
    public static void testSubList() {
        List<String> list=new  ArrayList<>();
        list.add("d");
        list.add("33");
        list.add("44");
        list.add("55");
        list.add("66");

        List<String> list2 = new ArrayList<>();
        list2.addAll(list.subList(2, list.size()));
        list2.add("77");
        System.out.println("删除前 list size="+list.size()+" | list2 size="+list2.size());

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String v = it.next();
            if("55".equals(v) ){
                it.remove();
            }
        }

        System.out.println("删除后 list size="+list.size()+" | list2 size="+list2.size());
    }

    /**
     * for循环删除有BUG：删除元素后一个会跳过遍历
     * 应该使用迭代器操作删除
     */
    public static void testListRemove() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);

        // 边循环边删除有BUG
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));
            if (list.get(i) == 3) {
                list.remove(list.get(i));
            }
        }
        System.out.println("使用for删除后的list==========3未全部删除" + Arrays.toString(list.toArray()));

        Iterator<Integer> it = list2.iterator();
        while(it.hasNext()){
            Integer v = it.next();
            if(4 == v){
                it.remove();
            }
        }
        System.out.println("使用迭代器删除后的list2==========4已全部删除"+ Arrays.toString(list2.toArray()));

    }


    public static void main(String[] args) {
        testInit();
//        testSubList();
//        testListRemove();
    }
}
