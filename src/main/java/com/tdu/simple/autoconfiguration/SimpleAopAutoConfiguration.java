package com.tdu.simple.autoconfiguration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 
	@Before – 目标方法执行前执行
	@After – 目标方法执行后执行
	@AfterReturning – 目标方法返回后执行，如果发生异常不执行
	@AfterThrowing – 异常时执行
	@Around – 在执行上面其他操作的同时也执行这个方法
 */
@Configuration
@Aspect
public class SimpleAopAutoConfiguration {

	private static final Logger logger = LoggerFactory.getLogger("SystemLogInfo");

	@Pointcut("execution(* com.tdu..*.service..*(..))")
	private void serviceExecuteMethod() {
	}

	@Before("serviceExecuteMethod()")
	public void before(JoinPoint joinPoint) {
		logger.info("before " + joinPoint);
	}

	@After("serviceExecuteMethod()")
	public void after(JoinPoint joinPoint) {
		logger.info("after " + joinPoint);
	}

	@Around("serviceExecuteMethod()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result=null;
		try {
			result= joinPoint.proceed();
			long end = System.currentTimeMillis();
			logger.info("around " + joinPoint + "\t Use time : " + (end - start) + " ms!");
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			logger.info(
					"around " + joinPoint + "\t Use time : " + (end - start) + " ms with exception : " + e.getMessage());
			throw e;
		}
		return result;
	}

	@AfterThrowing(pointcut = "serviceExecuteMethod()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		logger.info("afterThrow " + joinPoint + "\t " + ex.getMessage());
	}
}
