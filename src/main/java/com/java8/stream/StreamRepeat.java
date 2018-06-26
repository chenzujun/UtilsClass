/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.java8.stream;

import com.bean.Person;
import com.bean.Student;
import com.bean.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 对象集合中筛选重复数据
 *
 * @author chenjun
 * @date 2018/6/25
 * @since V1.0.0
 */
public class StreamRepeat {

    public static void  filterDuplicateData(){
        List<String> list2 = Arrays.asList("123", "1234", "12345", "123456", "1234567", "122222223", "123", "1234", "2422");
        Map<String, Long> collect = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    public static void  filterDuplicateDataObj(List<? extends Person> list ){
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        System.out.println(map.toString());

        map.forEach((k,v)->{
            if(v>1){
                System.out.println("地址（Address）重复："+k);
            }
        });

    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("李果");
        User s2 = new User();
        s2.setName("张");
        User s3 = new User();
        s3.setName("张奎");
        User s4 = new User();
        s4.setName("张");
        List<Person> list = Arrays.asList(p,s2,s3,s4);

        List<User> userList = Arrays.asList(s2,s3,s4);

        filterDuplicateDataObj(list);
        filterDuplicateDataObj(userList);
    }
}
