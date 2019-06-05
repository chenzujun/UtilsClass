package com.designpatterns.template;

import com.designpatterns.template.impl.ConcreteClass;

/**
 *
 * 重写怎么没生效
 * @author chenjun
 * @date 2019/6/5
 * @since V1.0.0
 */
public class TemplateTest {

    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.templateMethod();
    }

}
