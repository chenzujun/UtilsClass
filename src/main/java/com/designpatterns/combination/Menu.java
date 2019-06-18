package com.designpatterns.combination;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 菜单
 *
 * @author chenjun
 * @date 2019/6/14
 * @since V1.0.0
 */
public class Menu extends MenuComponent {
    private ArrayList menuComponents = new ArrayList();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public Iterator creatIterator(){
        return new CompositeIterator(menuComponents.iterator());
    }

    @Override
    public void print() {
        System.out.print("    "+getName());
        System.out.println("    --"+getDescription());
        System.out.println("----------------------------------------");
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.print();
        }
        System.out.println();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        this.menuComponents.add(menuComponent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
