package com.tdu.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class TraceService {

	@Autowired
	CounterService counterService;

	public String echo(String data) {
		counterService.increment("trace.info");
		return "hi.";
	}
}
