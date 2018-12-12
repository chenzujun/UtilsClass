package com.designpatterns.singleton;


/**
 * 单例模式内部类实现
 *
 * @author chenjun
 * @date 2018/12/12
 * @since V1.0.0
 */
public class SingletonInternalClass {
    private static class SingletonHolder {
        private static final SingletonInternalClass INSTANCE = new SingletonInternalClass();
    }

    public SingletonInternalClass() {
    }
    public static final SingletonInternalClass getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(){
                public void run(){
                    System.out.println(SingletonInternalClass.getInstance());
                }
            }.start();
        }
    }
}
