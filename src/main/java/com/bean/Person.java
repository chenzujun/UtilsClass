package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @description:
 * @author: mustang
 * @create: 2018-06-05
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 5548105142011789878L;

    public enum Sex{
        MALE,FEMALE
    }

    private String name;
    public LocalDate birthday;
    private Sex gender;
    private String emailAddress;
    private transient String salary;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public static int compareByAge(Person a, Person b){
        return a.birthday.compareTo(b.birthday);
    }
}
