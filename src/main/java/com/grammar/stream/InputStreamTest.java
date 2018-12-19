package com.grammar.stream;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenjun
 * @date 2018/12/14
 * @since V1.0.0
 */
public class InputStreamTest {

    public static String readBytes(InputStream in) throws IOException {
        byte[] data = new byte[in.available()];
        in.read(data);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    public static String readBytes2(InputStream in) throws IOException {
        byte[] data = new byte[in.available()];
        int offset = 0;
        int bytesRead;
        while ((bytesRead = in.read(data, offset, data.length - offset))
                != -1) {
            offset += bytesRead;
            if (offset >= data.length) {
                break;
            }
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    public static void main(String[] args) throws IOException {
        String imgFilePath =  "\\C:\\Users\\chenjun01\\Pictures\\学习内容留存率.png";
        InputStream in = new FileInputStream(imgFilePath);
        String str1 = InputStreamTest.readBytes(in);
        System.out.println(str1);

        InputStream in2 = new FileInputStream(imgFilePath);
        String str2 = InputStreamTest.readBytes2(in2);
        System.out.println(str2);
    }

}
