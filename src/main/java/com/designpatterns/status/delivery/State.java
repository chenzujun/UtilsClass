package com.designpatterns.status.delivery;

/**
 * 派送状态
 *
 * @author chenjun
 * @date 2019/7/5
 * @since V1.0.0
 */
public interface State {

    /**
     * 仓库签入
     */
    void whIn();

    /**
     * 仓库签出
     */
    void whOut();

    /**
     * 开始派送
     */
    void delivery();

    /**
     * 签收
     */
    void sign();

    /**
     * 签收异常
     */
    void signException();

    /**
     * 异常件上架
     */
    void exceptionOnShelves();
}
