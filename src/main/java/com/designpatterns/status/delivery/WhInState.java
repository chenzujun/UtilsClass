package com.designpatterns.status.delivery;

/**
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public class WhInState implements State {
    Context context;
    public WhInState(Context context) {
        this.context = context;
    }

    @Override
    public void whIn() {
        System.out.println("YES 仓库  收到货了");
    }

    @Override
    public void whOut() {
        System.out.println("YES 仓库  跳过签入，直接签出");
    }

    @Override
    public void delivery() {
        System.out.println("YES 仓库  跳过签入，直接派送");
        context.setState(context.getDeliveryState());
    }

    @Override
    public void sign() {
        System.out.println("NO 签入节点不能操作签收");
    }

    @Override
    public void signException() {
        System.out.println("NO 签入节点不能操作签收异常");
    }

    @Override
    public void exceptionOnShelves() {
        System.out.println("NO 签入节点不能操作异常件上架");
    }
}
