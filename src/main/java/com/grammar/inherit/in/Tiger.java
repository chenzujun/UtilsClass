package com.grammar.inherit.in;

import com.grammar.inherit.Animal;

/**
 * @author chenjun
 * @date 2018/9/25
 * @since V1.0.0
 */
public class Tiger extends Animal {

    private String tigerPrivateVal;

    public String getTigerPrivateVal() {
        return tigerPrivateVal;
    }

    public void setTigerPrivateVal(String tigerPrivateVal) {
        this.tigerPrivateVal = tigerPrivateVal;
    }

    public Tiger() {
    }

    public Tiger(String name, Integer age, String privateVal, String defaultVal, String protectedVal, String tigerPrivateVal) {
        super(name, age, privateVal, defaultVal, protectedVal);
        this.tigerPrivateVal=tigerPrivateVal;
    }

    @Override
    public String toString() {
        return super.toString()+"Tiger{" +
                "tigerPrivateVal='" + tigerPrivateVal + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", protectedVal='" + protectedVal + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger("老虎",1,"private val","default val","protected val","tiger private val");
        System.out.println(tiger.toString());
        System.out.println(tiger.age);
        System.out.println(tiger.getPrivateVal());
    }

}
