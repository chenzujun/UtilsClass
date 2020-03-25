package com.test;

/**
 * @author chenjun
 * @date 2020/3/25
 * @since V1.0.0
 */
public class SpringBeanUtilsPropertiesCopier implements PropertiesCopier {
    @Override
    public void copyProperties(Object source, Object target) throws Exception {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
    }
}
