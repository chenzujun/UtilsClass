package com.designpatterns.command.impl;

import com.designpatterns.command.Command;

/**
 * 什么都不做
 *
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("execute | do nothing");
    }

    @Override
    public void undo() {
        System.out.println("undo | do nothing");
    }
}
