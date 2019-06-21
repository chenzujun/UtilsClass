package com.designpatterns.adapter;

import com.designpatterns.adapter.kind.Adapter;
import com.designpatterns.adapter.kind.Target;

/**
 * 类的适配器模式测试
 *
 * @author chenjun
 * @date 2019/6/21
 * @since V1.0.0
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
