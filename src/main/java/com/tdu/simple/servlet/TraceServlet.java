package com.tdu.simple.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@WebServlet(urlPatterns = { "/boot_trace/*" }, description = "test")
public class TraceServlet extends HttpServlet {
	private static final long serialVersionUID = -666681787473608069L;

	private final static Logger logger = LoggerFactory.getLogger(TraceServlet.class);

	@Override
	
	@ApiOperation(value = "获取所有客户地址信息HttpServletRequest", notes = "获取所有客户地址信息HttpServletRequest")
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("echo {}", new DateTime().toString("yyyy-MM-dd"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
