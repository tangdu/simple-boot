package com.tdu.simple.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdu.simple.service.TraceService;

@RestController
public class IndexController {

	@Autowired
	private TraceService traceService;
	
	@RequestMapping(value={"/index","/"})
	public @ResponseBody String index(){
		traceService.echo("..........now rpt...");
		return "SpringBoot";
	}
}
