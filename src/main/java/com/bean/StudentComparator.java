package com.bean;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
public class StudentComparator {
    public int compareStudentByScore(Student student1,Student student2){
        return student2.getScore() - student1.getScore();
    }
}
