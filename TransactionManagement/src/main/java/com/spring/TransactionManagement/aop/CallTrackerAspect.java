package com.spring.TransactionManagement.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * Note: Only stereotype annotations create a bean
 * hence @Aspect will not create a bean. So need a @Component annotation to create a bean
 * ProceedingJoinPoint has the current method
 *ProceedingJoinPoint cannot be passed as an argument inside @Before or @After methods
 *If @Around method is declared we have to call the method using proceed method 
 */
@Aspect
@Component
public class CallTrackerAspect {

	@Pointcut(value = "within(com..service.*)||within(com..dao.*)")
	public void logPointCut() {
		System.out.println("Inside point Cut");
	}

	@Before(value = "logPointCut()")
	public void logBeforeMethodCall() {
		System.out.println("@Before every method call");
	}

	@After(value = "logPointCut()")
	public void logAfterMethodCall() {
		System.out.println("@After every method call");
	}

	//
	@Around(value = "logPointCut()")
	public Object logMethodCall(ProceedingJoinPoint process) throws Throwable {
		Object returnValue = process.proceed();// invokes the target method
		System.out.println("Around(before and after) method call: " + process.getSignature().getName());
		System.out.println(returnValue);
		return returnValue;
	}
}
