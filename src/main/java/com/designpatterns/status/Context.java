package com.designpatterns.status;

/**
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public class Context {
    /**
     * 定义炸楼所有状态
     */
    public final static CarryingState carryingState = new CarryingState();
    public final static PuttingState puttingState = new PuttingState();
    public final static GoAwayingState goawayingState = new GoAwayingState();
    public final static IgnitingState ignitingState = new IgnitingState();

    /**
     * 设置当前状态
     */
    private LinkState linkState;

    public LinkState getLinkState() {
        return linkState;
    }

    public void setLinkState(LinkState linkState) {
        this.linkState = linkState;
        //把当前的所处的状态通知到各个实现类中
        this.linkState.setContext(this);
    }

    public void carry() {
        this.linkState.carry();
    }

    public void put() {
        this.linkState.put();
    }

    public void goaway() {
        this.linkState.goaway();
    }

    public void ignite() {
        this.linkState.ignite();
    }
}
