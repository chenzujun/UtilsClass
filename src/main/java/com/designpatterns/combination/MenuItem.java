package com.designpatterns.combination;

import lombok.Data;

import java.util.Iterator;

/**
 * 菜单项
 *
 * @author chenjun
 * @date 2019/6/14
 * @since V1.0.0
 */
@Data
public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public Iterator creatIterator(){
        return new NullIterator();
    }

    @Override
    public void print(){
        System.out.print("    "+name);
        if(isVegetarian()){
            System.out.print(" (v) ");
        }
        System.out.print(", "+price);
        System.out.println("    --"+description);
    }

}
