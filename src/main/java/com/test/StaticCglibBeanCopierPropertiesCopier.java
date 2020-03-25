package com.test;

import com.bean.Person;
import net.sf.cglib.beans.BeanCopier;

/**
 * @author chenjun
 * @date 2020/3/25
 * @since V1.0.0
 */
public class StaticCglibBeanCopierPropertiesCopier implements PropertiesCopier {
    /**
     * 全局静态 BeanCopier，避免每次都生成新的对象
     */
    private static BeanCopier copier = BeanCopier.create(Person.class, Person.class, false);

    @Override
    public void copyProperties(Object source, Object target) throws Exception {
        copier.copy(source, target, null);
    }
}