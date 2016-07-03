package com.tdu.simple.autoconfiguration;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan(
	basePackages = { 
		"com.tdu.simple.dao" 
	}
)
@ServletComponentScan(
	basePackages = { 
			"com.tdu.simple.servlet"
	}
)
public class ModuleAutoConfiguration {

}
