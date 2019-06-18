package com.designpatterns.combination;

import java.util.Iterator;

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

    public void printVegetarianMenu(){
        Iterator iterator = allMenus.creatIterator();
        System.out.println("\nVEGETARIAN MENU\n---");
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            try{
                if(menuComponent.isVegetarian()){
                    menuComponent.print();
                }
            }catch (UnsupportedOperationException e){}
        }
    }
}
