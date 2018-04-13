package com.designpatterns.observer;

import com.google.common.eventbus.Subscribe;

/**
 * 实现对多个消息的订阅
 * 
 * @author chen_
 *
 */
public class MultipleListener {
	public Integer lastInteger;
	public Long lastLong;

	@Subscribe
	public void listenInteger(Integer event) {
		lastInteger = event;
		System.out.println("event Integer:" + lastInteger);
	}

	@Subscribe
	public void listenLong(Long event) {
		lastLong = event;
		System.out.println("event Long:" + lastLong);
	}

	public Integer getLastInteger() {
		return lastInteger;
	}

	public Long getLastLong() {
		return lastLong;
	}
}