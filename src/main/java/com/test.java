package com;

import com.bean.Animal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjun
 * @date 2019/1/24
 * @since V1.0.0
 */
public class test {
    public static void main(String[] args) {
        Map<Animal,Object> map = new HashMap<Animal, Object>(6){
            {
                put(new Animal("老虎"), new Object());
            }
        };

        boolean b1 = map.containsKey(new Animal("老虎"));

        System.out.println(b1);
    }
}
