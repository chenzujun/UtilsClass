package com.designpatterns;

import com.bean.Computer;
import com.common.ResponseCodeConstants;
import com.common.ResponseMessage;

/**
 * @author chenjun
 * @date 2020/4/1
 * @since V1.0.0
 */
public class BuilderTest {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("i5","8G")
                .setDisplay("24寸")
                .setKeyboard("黑猫")
                .setUsbCount(3)
                .build();
        System.out.println(computer.toString());

        ResponseMessage res = new ResponseMessage.Builder().success().build();
        System.out.println(res);

        ResponseMessage res2 = new ResponseMessage.Builder().fail(ResponseCodeConstants.ERROR_CODE_HTTP_REQUEST_EXCEPTION).build();
        System.out.println(res2);
    }
}
