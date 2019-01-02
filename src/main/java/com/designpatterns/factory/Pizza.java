package com.designpatterns.factory;

public interface Pizza {
    void createPizza();

    Pizza orderPizza();
    void prepare();
    void bake();
    void cut();
    void box();
}
