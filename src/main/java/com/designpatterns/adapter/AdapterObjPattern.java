package com.designpatterns.adapter;

import com.designpatterns.adapter.obj.Adaptee;
import com.designpatterns.adapter.obj.Adapter;
import com.designpatterns.adapter.obj.Target;

/**
 * @author chenjun
 * @date 2019/6/21
 * @since V1.0.0
 */
public class AdapterObjPattern {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
