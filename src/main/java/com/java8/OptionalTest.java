/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.java8;


import com.bean.User;
import org.apache.commons.lang.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * java8 Optional 学习
 *
 * @author chenjun
 * @date 2018/6/13
 */
public class OptionalTest {

    public static void create(){
        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(null);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(new Integer(10));

        List<User> userList = new ArrayList<>(1);
        User user = new User();
        user.setName("alpha");
        userList.add(user);
        User user2 = new User();
        user2.setName("lie");
        userList.add(user2);
        Optional<List<User>> userListOptional = Optional.ofNullable(userList);

        System.out.println(a.orElse(NumberUtils.INTEGER_ZERO));
        System.out.println(b.get());
        List<User> users = userListOptional.get();
        users.forEach(e-> System.out.println(e.getName()));
    }

    public static void handle(){
        List<User> userList = new ArrayList<>(1);
        User user = new User();
        user.setName("alpha");
        userList.add(user);
        User user2 = new User();
        user2.setName("lie");
        userList.add(user2);
        Optional<List<User>> userListOptional = Optional.ofNullable(userList);

        String str = userListOptional.map(l -> l.get(0))
                .map(u -> u.getName())
                .map(name -> name.toUpperCase())
                .orElse(null);

        userListOptional.get().forEach(e-> System.out.println(e.getName()));
        System.out.println(str);
    }

    public static void main(String[] args) {
        handle();
    }
}
