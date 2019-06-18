package com.designpatterns.combination;

/**
 * @author chenjun
 * @date 2019/6/17
 * @since V1.0.0
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "LUNCH");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "DINNER");

        MenuComponent allMenus = new Menu("ALL MENUS", "ALL menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem("qiezibao", "辣", true, 15.00));
        dinerMenu.add(new MenuItem("xihongshigaifan", "辣", true, 14.00));
        dinerMenu.add(new MenuItem("hongshaorou", "辣", false, 25.00));

        MenuComponent westernFoodMenu = new Menu("WESTERN FOOD MENU", "DINNER");
        westernFoodMenu.add(new MenuItem("niupai", "7分熟", false, 40.00));
        westernFoodMenu.add(new MenuItem("sela", "蔬菜", true, 10.00));
        dinerMenu.add(westernFoodMenu);

        Waitress waitress = new Waitress(allMenus);
//        waitress.printMenu();
        waitress.printVegetarianMenu();
    }
}
