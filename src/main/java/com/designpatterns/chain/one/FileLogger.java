package com.designpatterns.chain.one;

/**
 * @author chenjun
 * @date 2019/6/6
 * @since V1.0.0
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}