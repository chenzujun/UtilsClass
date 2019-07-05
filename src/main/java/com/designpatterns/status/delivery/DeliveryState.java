package com.designpatterns.status.delivery;

/**
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public class DeliveryState implements State {
    Context context;
    public DeliveryState(Context context) {
        this.context = context;
    }

    @Override
    public void whIn() {
        System.out.println("NO ");
    }

    @Override
    public void whOut() {
        System.out.println("NO ");
    }

    @Override
    public void delivery() {
        System.out.println("NO ");
    }

    @Override
    public void sign() {
        System.out.println("YES 客户签收了");
    }

    @Override
    public void signException() {
        System.out.println("YES 客户签收异常了");
    }

    @Override
    public void exceptionOnShelves() {
        System.out.println("NO 签收不能操作异常件上架");
    }
}
