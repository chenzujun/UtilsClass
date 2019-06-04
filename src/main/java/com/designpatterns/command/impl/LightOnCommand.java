package com.designpatterns.command.impl;

import com.designpatterns.command.Command;
import com.designpatterns.command.Light;

/**
 * 开灯命令
 *
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
