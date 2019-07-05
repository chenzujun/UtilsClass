package com.designpatterns.status;

/**
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public abstract class LinkState{
    protected Context context;
    public void setContext(Context  context){
        this.context = context;
    }
    //扛炸药包
    public abstract void carry();
    //放置炸药包
    public abstract void put();
    //跑路
    public abstract void goaway();
    //点燃炸药包
    public abstract void ignite();

}