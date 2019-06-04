package com.designpatterns.command;

import lombok.Data;

/**
 * 灯
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
@Data
public class Light {
    private String name;

    public Light() {
    }

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println(this.name +" is on");
    }

    public void off(){
        System.out.println(this.name +" is off");
    }
}
