package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private int score;
    public String nickName;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static Student create(final Supplier<Student> supplier) {
        return supplier.get();
    }

    public void answerQuestion(Student student) {
        System.out.println(student.name + ": answer question ");
    }

    public void exercise() {
        System.out.println(this.toString() + ": exercise ");
    }

    public static int compareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }
}
