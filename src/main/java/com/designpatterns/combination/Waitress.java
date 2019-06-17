package com.designpatterns.combination;

/**
 * 服务
 *
 * @author chenjun
 * @date 2019/6/17
 * @since V1.0.0
 */
public class Waitress {
    private MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }
}
