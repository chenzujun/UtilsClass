package com.grammar.excp.ioe;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author chenjun
 * @date 2019/4/16
 * @since V1.0.0
 */
public class BrokenPipeClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket();
            //设置调用close就发送RST
            s.setSoLinger(true,0);
            s.connect(new InetSocketAddress("127.0.0.1",3113));

            OutputStream os = s.getOutputStream();
            os.write("hello".getBytes());

            s.close();
            //防止程序退出
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
