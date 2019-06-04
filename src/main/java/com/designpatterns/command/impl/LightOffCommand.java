package com.designpatterns.command.impl;

import com.designpatterns.command.Command;
import com.designpatterns.command.Light;

/**
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
