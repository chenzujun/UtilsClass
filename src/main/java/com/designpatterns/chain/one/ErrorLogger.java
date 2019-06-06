package com.designpatterns.chain.one;

/**
 * @author chenjun
 * @date 2019/6/6
 * @since V1.0.0
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
