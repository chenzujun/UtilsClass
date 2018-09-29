package com.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 测试fastjson
 *
 * @author chenjun
 * @date 2018/9/28
 * @since V1.0.0
 */
public class FastJsonBean {
    @JSONField(name="name")
    private String name;
    @JSONField(name="age2")
    private int age;
    @JSONField(name="integerVal")
    private Integer integerVal;
    @JSONField(serialize = false, deserialize = false)
    private int hiddenVal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getIntegerVal() {
        return integerVal;
    }

    public void setIntegerVal(Integer integerVal) {
        this.integerVal = integerVal;
    }

    public int getHiddenVal() {
        return hiddenVal;
    }

    public void setHiddenVal(int hiddenVal) {
        this.hiddenVal = hiddenVal;
    }

    @Override
    public String toString() {
        return "FastJsonBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hiddenVal=" + hiddenVal +
                '}';
    }
}
