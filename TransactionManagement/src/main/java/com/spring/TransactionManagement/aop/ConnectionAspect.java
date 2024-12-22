package com.spring.TransactionManagement.aop;

import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.postgresql.jdbc.PgConnection;
import org.springframework.stereotype.Component;

import com.spring.TransactionManagement.aop.ivh.ConnectionInvocationHandler;

@Aspect
@Component
public class ConnectionAspect {

	/*
	 * target for inbuilt classes within for user defined classes
	 */
	@Pointcut("target(javax.sql.DataSource)")
	public void dataSourcePointCut() {
		System.out.println("Inside datasource pointcut()");
	}

	/*
	 * Here we directly mention the package instead of using PointCut because we are
	 * gonna check only one class
	 */

	// @Around("dataSourcePointCut()")
	@Around(value = "target(javax.sql.DataSource)")

	public Object logDataSourceConnection(ProceedingJoinPoint process) throws Throwable {
		System.out.println("Before " + process.getSignature().getName()+ " call");
		Object returnValue = process.proceed();
		if (returnValue instanceof Connection) {
			System.out.println("before calling proxy");
			Connection con = (Connection) Proxy.newProxyInstance(PgConnection.class.getClassLoader(),
					new Class[] { Connection.class }, new ConnectionInvocationHandler((Connection) returnValue));
			return con;
		}
		return returnValue;
	}
}
