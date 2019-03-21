package com;

import com.bean.Student;

/**
 * @author chenjun
 * @date 2019/1/24
 * @since V1.0.0
 */
public class test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("test");
        student.setNickName("nick");

        System.out.println("getNickName:"+student.getNickName());
        System.out.println("nickName:"+student.nickName);

        student.nickName="::";
        System.out.println("getNickName:"+student.getNickName());
        System.out.println("nickName:"+student.nickName);

    }
}
