package com.test;

import net.sf.cglib.beans.BeanCopier;

/**
 * @author chenjun
 * @date 2020/3/25
 * @since V1.0.0
 */
public class CglibBeanCopierPropertiesCopier implements PropertiesCopier {
    @Override
    public void copyProperties(Object source, Object target) throws Exception {
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
    }
}