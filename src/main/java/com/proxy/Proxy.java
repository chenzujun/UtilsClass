package com.proxy;

/**
 * 
 * @ClassName: Proxy 
 * @Description: 静态代理
 * @author chenjun
 * @date 2017年3月16日 上午10:24:01 
 *
 */
public class Proxy implements Subject {

	private Subject subject;
	
	public Proxy(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void request(){
        System.out.println("begin");
        subject.request();
        System.out.println("end");
    }
}
