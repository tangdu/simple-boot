package com.tdu.simple.autoconfiguration.druid;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

/**
 * Durid数据源
 * 
 * @author tangdu
 *
 */
@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(DruidProperties.class)
public class DruidAutoConfiguration {

	private static final List<String> EXCLUSIONS = new ArrayList<>();

	static {
		EXCLUSIONS.add("*.js");
		EXCLUSIONS.add("*.css");
		EXCLUSIONS.add("*.jpg");
		EXCLUSIONS.add("*.gif");
		EXCLUSIONS.add("*.png");
		EXCLUSIONS.add("*.ico");
		EXCLUSIONS.add("*.js");
		EXCLUSIONS.add("/druid/*");
	}

	@Autowired
	private DruidProperties druidProperties;

	@Bean
	public ServletRegistrationBean druidServlet() {
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}

	@Bean
	DataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setPassword(druidProperties.getPassword());
		dataSource.setUrl(druidProperties.getUrl());
		dataSource.setUsername(druidProperties.getUsername());
		dataSource.setDriverClassName(druidProperties.getDriverClassName());
		try {
			dataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new WebStatFilter());
		filterRegistration.setInitParameters(ImmutableMap.of("exclusions", Joiner.on(",").join(EXCLUSIONS)));
		return filterRegistration;
	}

}
