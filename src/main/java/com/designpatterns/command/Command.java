package com.designpatterns.command;

/**
 * 命令接口
 *
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public interface Command {
    void execute();
    void undo();
}
