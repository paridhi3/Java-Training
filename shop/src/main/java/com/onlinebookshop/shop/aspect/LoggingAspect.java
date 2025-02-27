package com.onlinebookshop.shop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Indicates that this class is a Spring Aspect
@Component // Registers this aspect as a Spring bean
public class LoggingAspect {

    // Advice to be executed before methods in the service package
    @Before("execution(* com.onlinebookshop.shop.service.*.*(..))")
    public void beforeServiceMethod() {
        System.out.println("------- Logging from aspect: beforeServiceMethod called in service layer ---------");
    }

    // Advice to be executed after methods in the service package
    @After("execution(* com.onlinebookshop.shop.service.*.*(..))")
    public void afterServiceMethod() {
        System.out.println("--- Logging from aspect: afterServiceMethod execution completed in service layer ---");
    }
    
    @Around("execution(* com.onlinebookshop.shop.service.*.*(..))")
    public Object aroundServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        long startTime = System.currentTimeMillis();
        
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            System.err.println("Error occurred: " + e.getMessage());
            throw e; // rethrow the exception
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("--- Logging method execution time: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + ": " + (endTime - startTime) + "ms");
        return result;
    }
    
    @AfterReturning(pointcut = "execution(* com.onlinebookshop.shop.service.*.*(..))", returning = "result")
    public void afterReturningServiceMethod(Object result) {
        System.out.println("------- Logging: Method returned with value: " + result + " -------");
    }

    @AfterThrowing(pointcut = "execution(* com.onlinebookshop.shop.service.*.*(..))", throwing = "ex")
    public void afterThrowingServiceMethod(Exception ex) {
        System.out.println("------- Logging: Method threw exception: " + ex.getMessage() + " -------");
    }    
}
