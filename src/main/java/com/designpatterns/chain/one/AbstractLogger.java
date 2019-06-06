package com.designpatterns.chain.one;

/**
 * @author chenjun
 * @date 2019/6/6
 * @since V1.0.0
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    /**
     * 责任链中的下一个元素
     */
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    /**
     * 处理与调用解耦
     *
     * @param level
     * @param message
     */
    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }else if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
