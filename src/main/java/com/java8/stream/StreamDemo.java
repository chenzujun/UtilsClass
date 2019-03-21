package com.java8.stream;

import com.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
public class StreamDemo {

    private static List<Student> studentList;
    static {
        Student student1 = new Student("zhangsan", 60);
        Student student2 = new Student("wangwu", 80);
        Student student3 = new Student("lisi", 70);
        Student student4 = new Student("zhaoliu", 90);
        studentList = Arrays.asList(student1, student2, student3, student4);
    }

    public static void testProcess(){
        Student student1 = new Student("zhangsan", 60);
        Student student2 = new Student("wangwu", 80);
        Student student3 = new Student("lisi", 70);
        Student student4 = new Student("zhaoliu", 90);
        // 1 创建集合
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // 集合数据打印
        System.out.println("开始集合");
        students.forEach(e -> System.out.println("name="+e.getName()+"|score="+e.getScore()+"|hashcode="+e.hashCode()));
        System.out.println();
        // 2 中间操作
        Stream<Student> stream = students.stream()
                .filter((e) -> {System.out.println("惰性求值");return e.getScore() < 80;})
                .map(e->{e.setName(e.getName().toUpperCase());return e;})
                .limit(1);
        System.out.println("执行最终操作--------------------");
        // 3 终止操作
        List<Student> resultList = stream.collect(Collectors.toList());
        // 结果数据打印
        resultList.forEach(e -> System.out.println("name="+e.getName()+"|score="+e.getScore()+"|hashcode="+e.hashCode()));
        System.out.println();
        System.out.println("经过处理后的集合");
        students.forEach(e -> System.out.println("name="+e.getName()+"|score="+e.getScore()+"|hashcode="+e.hashCode()));
    }

    /**
     * 一个 Stream 只可以使用一次
     */
    public static void testOneUse(){
        // 1、创建Stream，List<Student> studentList
        Stream<Student> streamStu = studentList.stream();
        Object[] s1 = streamStu.toArray();
        List<Student> list = streamStu.collect(Collectors.toList());
        list.forEach(e -> System.out.println("name="+e.getName()+"|score="+e.getScore()+"|hashcode="+e.hashCode()));
    }

    public static void main(String[] args) {
//        testOneUse();
        testProcess();
    }
}
