package com.loggingaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.controller.*.*(..))")
	private void beforeMethod(JoinPoint joinpoint){
		System.out.println("Entered in to method:"+joinpoint.getSignature().getName());
	}
	
	@After("execution(* com.controller.*.*(..))")
	private void afterMethod(JoinPoint joinpoint){
		System.out.println("Exit from method:"+joinpoint.getSignature().getName());
	}
	
	@Around("execution(*com.controller.*.*(..))")
	private void aroundMethod(ProceedingJoinPoint pj) throws Throwable{
		System.out.println("Before logic");
		Object returndata=pj.proceed();
		System.out.println("After logic"+pj.getSignature().getName());
		System.out.println("After logic"+pj.getTarget().getClass().toString());
	}

}
