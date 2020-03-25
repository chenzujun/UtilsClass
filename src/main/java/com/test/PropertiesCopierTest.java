package com.test;

import com.bean.Person;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author chenjun
 * @date 2020/3/25
 * @since V1.0.0
 */
@RunWith(Parameterized.class)
public class PropertiesCopierTest {
    @Parameterized.Parameter(0)
    public PropertiesCopier propertiesCopier;
    /**
     * 测试次数
     */
    private static List<Integer> testTimes = Arrays.asList(100, 1000, 10000, 100000, 1000000);
    /**
     * 测试结果以 markdown 表格的形式输出
     */
    private static StringBuilder resultBuilder = new StringBuilder("|实现|100|1,000|10,000|100,000|1,000,000|\n").append("|----|----|----|----|----|----|\n");

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new StaticCglibBeanCopierPropertiesCopier()});
        params.add(new Object[]{new CglibBeanCopierPropertiesCopier()});
        params.add(new Object[]{new SpringBeanUtilsPropertiesCopier()});
        return params;
    }

    @Before
    public void setUp() throws Exception {
        String name = propertiesCopier.getClass().getSimpleName().replace("PropertiesCopier", "");
        resultBuilder.append("|").append(name).append("|");
    }

    @Test
    public void copyProperties() throws Exception {
        Person source = new Person("吉柜", LocalDate.of(2017, 12, 25), Person.Sex.MALE, "");
        Person target = new Person();
        // 预热一次
        propertiesCopier.copyProperties(source, target);
        for (Integer time : testTimes) {
            long start = System.nanoTime();
            for (int i = 0; i < time; i++) {
                propertiesCopier.copyProperties(source, target);
            }
            resultBuilder.append((System.nanoTime() - start) / 1000000D).append("|");
        }
        resultBuilder.append("\n");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("测试结果：");
        System.out.println(resultBuilder);
    }
}
