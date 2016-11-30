package com.tdu.simple.test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MqClientTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void Test(){
	}
}
