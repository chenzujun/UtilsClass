package com.grammar.jdk;

import java.net.URL;

public class ClassLoaderTest {

    /**
     * BootStrap ClassLoader 类加载器从哪些地方加载了相关的jar或class文件
     * 
     * @Description: TODO
     * @param
     * @return void
     * @throws
     */
    public void loadClassFrom() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    /**
     * 
     * @Description: 类加载器
     * @param
     * @return void
     * @throws
     */
    public void classLoaderStructure() {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader(); // 获得加载ClassLoaderTest.class这个类的类加载器
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent(); // 获得父类加载器的引用
        }
        System.out.println(loader);
    }

    public static void main(String[] args) {
        new ClassLoaderTest().loadClassFrom();

        new ClassLoaderTest().classLoaderStructure();
    }
}
