package com.designpatterns.adapter.custom;

import java.util.Enumeration;

/**
 * @author chenjun
 * @date 2019/12/16
 * @since V1.0.0
 */
public class MyEnumeration implements Enumeration {
    int count;
    int length;
    String[] dataArray;

    MyEnumeration(int count, int length, String[] dataArray) {
        this.count = count;
        this.length = length;
        this.dataArray = dataArray;
    }

    @Override
    public boolean hasMoreElements() {
        return (count < length);
    }

    @Override
    public Object nextElement() {
        return dataArray[count++];
    }
}
