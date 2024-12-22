package com.spring.TransactionManagement.aop.ivh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {

	private Connection connection;

	public ConnectionInvocationHandler(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Inside Connection Invocation Handler: "+method.toGenericString()	);
		if (method.getName().contains("commit") || method.getName().contains("rollback")
				|| method.getName().contains("close"))
			System.out.println("inside " + method.toGenericString());

		return method.invoke(connection, args);
	}

}
