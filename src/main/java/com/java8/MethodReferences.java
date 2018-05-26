package com.java8;

import com.bean.Student;
import com.bean.StudentComparator;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 直接引用已有Java类或对象（实例）的方法或构造器
 * @author: mustang
 * @create: 2018-05-26
 **/
public class MethodReferences {
    public static void main(String[] args) {
        StudentComparator studentComparator = new StudentComparator();

        Student student1 = new Student("zhangsan",60);
        Student student2 = new Student("wangwu",80);
        Student student3 = new Student("lisi",70);
        Student student4 = new Student("zhaoliu",90);
        Student student5 = Student.create(Student::new);

        List<Student> students = Arrays.asList(student1,student2,student3,student4,student5);

        students.sort((o1, o2) -> o1.getScore() - o2.getScore());
        // 静态方法引用
        students.sort(Student::compareStudentByScore);
        // 特定对象的方法引用
        students.sort(studentComparator::compareStudentByScore);
        // 特定类的任意对象的方法引用
        students.forEach( Student::exercise);


        students.forEach(student -> System.out.println(student.getScore()));

    }
}
