package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
