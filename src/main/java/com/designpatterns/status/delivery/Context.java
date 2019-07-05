package com.designpatterns.status.delivery;

/**
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public class Context {
    State whInState;
    State deliveryState;
    State state;

    public Context(){
        whInState = new WhInState(this);
        deliveryState = new DeliveryState(this);
        state = whInState;
    }

    public void whIn() {
        state.whIn();
    }

    public void whOut() {
        state.whOut();
    }

    public void delivery() {
        state.delivery();
    }

    public void sign() {
        state.sign();
    }

    public void signException() {
        state.signException();
    }

    public void exceptionOnShelves() {
        state.exceptionOnShelves();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getWhInState() {
        return whInState;
    }

    public State getDeliveryState() {
        return deliveryState;
    }
}
