package com.java8.reference;

import com.bean.Person;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: mustang
 * @create: 2018-06-05
 **/
public class MethodReferenceTest {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("吉柜", LocalDate.of(2017, 12, 25), Person.Sex.MALE, "");
        persons[1] = new Person("安朵", LocalDate.of(2016, 12, 25), Person.Sex.FEMALE, "");
        persons[2] = new Person("安朵1", LocalDate.of(2018, 4, 25), Person.Sex.FEMALE, "");

        Arrays.stream(persons).forEach(e -> System.out.println(e.toString()));

        //使用匿名类
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.birthday.compareTo(o2.birthday);
            }
        });

        //使用lambda表达式
        Arrays.sort(persons, (o1, o2) -> o1.birthday.compareTo(o2.birthday));

        //使用lambda表达式和类的静态方法
        Arrays.sort(persons, (o1, o2) -> Person.compareByAge(o1, o2));

        //使用方法引用,引用的是类的静态方法
        Arrays.sort(persons, Person::compareByAge);

        Arrays.stream(persons).forEach(e -> System.out.println(e.toString()));
    }
}
