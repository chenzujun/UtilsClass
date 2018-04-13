package com.designpatterns.observer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.common.eventbus.EventBus;

/**
 * 用telnet命令登录：telnet 127.0.0.1 4444，
 * 如果你连接多个实例你会看到任何消息发送被传送到其他实例
 * 
 * @author chen_
 *
 */
public class EventBusChat {
    public static void main(String[] args) {
        EventBus channel = new EventBus();
        ServerSocket socket;
        try {
            socket = new ServerSocket(4444);
            while (true) {
                Socket connection = socket.accept();
                UserThread newUser = new UserThread(connection, channel);
                channel.register(newUser);
                newUser.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}