package com.tdu.simple.autoconfiguration;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
	basePackages = { 
			"com.tdu.simple.web",
			"com.tdu.simple.service",
			"com.tdu.simple.actuator"
	}
)
@ServletComponentScan(
	basePackages = { 
			"com.tdu.simple.servlet"
	}
)
public class ModuleAutoConfiguration {

}
