package com.designpatterns.chain.one;

/**
 * @author chenjun
 * @date 2019/6/6
 * @since V1.0.0
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}