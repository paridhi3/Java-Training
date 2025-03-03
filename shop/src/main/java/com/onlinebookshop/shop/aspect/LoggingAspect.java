package com.onlinebookshop.shop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void beforeServiceMethod() {
		System.out.println("---Logging from aspect : Method called in service layer------");
	}
	
	@After("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterServiceMethod() {
		System.out.println("---Logging from aspect : Method execution completed in service layer------");
	}
	
	@Around("execution(* com.onlinebookshop.shop.service.*.*(..))")
	public Object aroundServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.currentTimeMillis();
		Object result=joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		System.out.println("----Logging : Method execution Time "+joinPoint.getSignature().getName()
				           + " executed in : " + (endTime-startTime));
		return result;
	}
	
	@AfterReturning("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterReturningServiceMethod() {
		System.out.println("---Logging from aspect : Method execution completed and returned in service layer------");
	}
	
	@AfterThrowing("execution(* com.onlinebookshop.shop.service.*.*(..)) ")
	public void afterThrowingServiceMethod() {
		System.out.println("---Logging from aspect : Exception thrown in service layer------");
	}
	
	

}
