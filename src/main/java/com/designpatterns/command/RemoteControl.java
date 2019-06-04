package com.designpatterns.command;

import com.designpatterns.command.impl.NoCommand;

import java.util.Arrays;

/**
 * 调用者
 *
 * @author chenjun
 * @date 2019/6/4
 * @since V1.0.0
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i=0;i<7;i++){
            onCommands[i]=noCommand;
            offCommands[i]=noCommand;
        }
    }

    public void setCommand(int index, Command onCommand, Command offCommand){
        onCommands[index] = onCommand;
        offCommands[index] = offCommand;
    }

    public void onButtonWasPushed(int index){
        onCommands[index].execute();
    }

    public void offButtonWasPushed(int index){
        offCommands[index].execute();
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
