package com.app.operative.employeemanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class EmployeeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.app.operative.employeemanagement.controller.*.*(..))")
	public void before(JoinPoint joinPoint){
		logger.info(" AOP is getting called before {}" ,joinPoint);
	} 
	
	@After("execution(* com.app.operative.employeemanagement.controller.*.*(..))")
	public void after(JoinPoint joinPoint){
		logger.info(" AOP is getting called after {}" ,joinPoint);
	} 
	
	@AfterReturning(value = "execution(* com.app.operative.employeemanagement.controller.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
}
