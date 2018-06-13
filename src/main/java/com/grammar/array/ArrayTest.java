package com.grammar.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

    public static void test() {
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

    public static void scopeTest() {
        List<String> errorList = new ArrayList<>();
        errorList.add("1");
        /*语句块内部*/
        try {
            errorList.add("2");
            throw new Exception();
        } catch (Exception e) {
            errorList.add("3");
        } finally {
            errorList.add("4");
        }
        errorList.forEach(e -> System.out.println(e));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        test();
        scopeTest();


    }

}
