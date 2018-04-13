package com.designpatterns.observer;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * EventBus发送的消息都不是订阅者关心的称之为Dead Event
 * 
 * @author chen_
 *
 */
public class DeadEventListener {
	boolean notDelivered = false;

	@Subscribe
	public void listen(DeadEvent event) {

		notDelivered = true;
	}

	public boolean isNotDelivered() {
		return notDelivered;
	}
}
