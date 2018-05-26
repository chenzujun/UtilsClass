package com.java8;

import com.java8.service.FourWheeler;
import com.java8.service.Vehicle;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
public class Car implements Vehicle, FourWheeler {

    /**
     * 重写
     */
    @Override
    public void print(){
        System.out.println("我是一辆四轮汽车!");
    }

    /**
     * super 来调用指定接口的默认方法
     */
//    @Override
//    public void print(){
//        Vehicle.super.print();
//    }

    public static void main(String[] args) {
        System.out.println("ok");
    }
}
