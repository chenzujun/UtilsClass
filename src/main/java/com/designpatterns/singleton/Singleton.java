package com.designpatterns.singleton;

/**
 * 单例模式：双重检查
 *
 * @author chenjun
 * @date 2018/12/12
 * @since V1.0.0
 */
public class Singleton {
    /**
     * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
     */
    private static volatile Singleton instance;

    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton() {
    }

    /**
     * 静态工厂方法，创建实例
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(){
                public void run(){
                    System.out.println(Singleton.getInstance());
                }
            }.start();
        }
    }
}
